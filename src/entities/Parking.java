package entities;

import java.util.*;

public class Parking {
	private Random rd = new Random();
	private List<String> parked = new ArrayList<String>();
	private List<String> parkingCar = new ArrayList<String>();
	private String[] parkingSpace;

	public Parking(){
		parkingSpace = new String[(rd.nextInt(6)+1)*10];
	}

	public boolean isParked(String carPlate){
		return parked.contains(carPlate) ? true : false;
	}
	
	public boolean isParkingCar(String carPlate){
		return parkingCar.contains(carPlate) ? true : false;
	}

	public void receivingCar(Car car) {
		if (isParked(car.getPlate()) || isParkingCar(car.getPlate())) {
			gettingCar(car);
		} else {
			parkingCar(car);
		}
	}

	void parkingCar(Car car) {
		boolean notFound = true;
		int size = parkingSpace.length;

		do {
			int index = rd.nextInt(size);

			if (parkingSpace[index] == null) {				
				car.setSpot(index);
				parkingSpace[index] = car.getPlate();
				parkingCar.add(car.getPlate());
				System.out.println(String.format("%s [vaga %s]\n",Thread.currentThread().getName(), index));
				try { Thread.sleep(index * 1000 + 10000); } catch (InterruptedException ex) {	ex.printStackTrace(); }							
				parked.add(car.getPlate());
				car.setParked(true);
				notFound = false;
				System.out.println(String.format("%s estacionou o carro [%s] na vaga %s.\n",Thread.currentThread().getName(),car.getPlate(), index));
			}
		} while (notFound);
		parkingCar.remove(car.getPlate());
	}

	void gettingCar(Car car) {
		boolean notFound = true;
		int size = parkingSpace.length;

		do {
			int index = rd.nextInt(size);

			if (parkingSpace[index] != null) {
				if (parkingSpace[index].equals(car.getPlate())) {	
					System.out.println(String.format("%s [vaga %s]\n",Thread.currentThread().getName(), index));
					parkingSpace[index] = null;
					parked.remove(car.getPlate());
					try { Thread.sleep(index * 1000 + 10000); } catch (InterruptedException ex) {	ex.printStackTrace(); }
					car.setParked(false);
					notFound = false;
					System.out.println(String.format("%s pegou o carro [%s] na vaga %s.\n",	Thread.currentThread().getName(), car.getPlate(), index));
									
				}
			}
		} while (notFound);
	}
}
