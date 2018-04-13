package entities;

import java.util.*;



public class ThreadDriver implements Runnable {
	private static Parking parking = new Parking();
	private Thread thread;
	private String name;
	private static List<Car> cars = new ArrayList<Car>();

	public ThreadDriver(String name) {
		Random rd = new Random();
		this.name = name;
		for (int i = 0; i < (rd.nextInt(50)); i++) { cars.add(new Car()); }
		thread = new Thread(this, name);
		thread.start();
	}

	public void run() {
		List<Car> auxCars = cars;

		for (int i = 0; i < cars.size(); i++) {
			System.out.println(String.format("%s vai atender o Cliente do carro %s", name, auxCars.get(i).getPlate()));
			parking.receivingCar(auxCars.get(i).getPlate());
			System.out.println(String.format("%s vai atender o próximo cliente", name));
		}

		//cars = auxCars;
	}
}
