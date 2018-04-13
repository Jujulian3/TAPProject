package entities;

import java.util.*;

public class Parking {
	private Random rd = new Random();
	private List<String> parked = new ArrayList<String>();
	private String[] parkingSpace;

	public Parking(){
		parkingSpace = new String[rd.nextInt(100)];
	}

	synchronized boolean isParked(String carPlate){
		if (parked.contains(carPlate)) {
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			return true;
		} else {
			Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
			return false;
		}
	}

	synchronized void receivingCar(String carPlate) {
		if (isParked(carPlate)) {
			gettingCar(carPlate);
		} else {
			parkingCar(carPlate);
		}
	}

	synchronized void parkingCar(String carPlate) {
		boolean notFound = true;

		do {
			int index = rd.nextInt(parkingSpace.length);

			if (parkingSpace[index].equals("")) {
				parkingSpace[index] = carPlate;
				parked.add(carPlate);
				notFound = false;
				System.out.println(String.format(
						"%s foi estacionar o carro %s na vaga %s.",
						Thread.currentThread().getName(),
						carPlate, index));
				try {
					Thread.sleep(index * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} while (notFound);
	}

	synchronized void gettingCar(String carPlate) {
		boolean notFound = true;

		do {
			int index = rd.nextInt(parkingSpace.length);

			if (parkingSpace[index].equals(carPlate)) {
				parkingSpace[index] = "";
				parked.remove(carPlate);
				notFound = false;
				System.out.println(String.format(
						"%s foi buscar o carro %s na vaga %s.",
						Thread.currentThread().getName(),
						carPlate, index));
				try {
					Thread.sleep(index * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} while (notFound);
	}
}
