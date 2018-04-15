package entities;

import java.util.*;

public class Parking {
	private Random rd = new Random();
	private List<String> parked = new ArrayList<String>();
	private String[] parkingSpace;

	public Parking(){
		parkingSpace = new String[rd.nextInt(51)+10];
	}

	boolean isParked(String carPlate){
		return parked.contains(carPlate) ? true : false;
	}

	void receivingCar(String carPlate) {
		if (isParked(carPlate)) {
			gettingCar(carPlate);
		} else {
			parkingCar(carPlate);
		}
	}

	void parkingCar(String carPlate) {
		boolean notFound = true;
		int size = parkingSpace.length;

		do {
			int index = rd.nextInt(size);

			if (parkingSpace[index] == null) {
				parkingSpace[index] = carPlate;
				parked.add(carPlate);
				notFound = false;
				System.out.println(String.format(
						"%s está estacionando o carro [%s] na vaga %s.\n",
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

	void gettingCar(String carPlate) {
		boolean notFound = true;
		int size = parkingSpace.length;

		do {
			int index = rd.nextInt(size);

			if (parkingSpace[index] != null) {
				if (parkingSpace[index].equals(carPlate)) {
					parkingSpace[index] = null;
					parked.remove(carPlate);
					notFound = false;
					System.out.println(String.format(
							"%s está buscando o carro [%s] na vaga %s.\n",
							Thread.currentThread().getName(),
							carPlate, index));
					try {
						Thread.sleep(index * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		} while (notFound);
	}
}
