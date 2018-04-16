package entities;

import java.util.*;



public class ThreadDriver implements Runnable {
	private static Parking parking = new Parking();
	private static List<Car> cars;
	private static List<Car> returnCars = new ArrayList<Car>();
	private static List<Car> parkedCars = new ArrayList<Car>();
	private Random rd = new Random();
	private Car car;
	private int canReturn;
	private Thread thread;
	private String name;

	public ThreadDriver(String name) {
		this.name = name;

		if (cars == null) {
			cars = new ArrayList<Car>();
			for (int i = 0; i < (rd.nextInt(51)+10); i++) { cars.add(new Car()); }
		}

		thread = new Thread(this, name);
		thread.start();
	}

	synchronized public void run() {

		System.out.println(String.format("%s iniciou seu trabalho.\n", name));

		do {			
			if (returnCars.size() > 0 ) {
				car = returnCars.get(0);
				returnCars.remove(0);
				parkedCars.remove(car);
			} else if (cars.size() > 0) {
				car = cars.get(0);
				cars.remove(0);
				parkedCars.add(car);
			} else {
				car = parkedCars.size() > 0 ? parkedCars.get(0) : new Car();
			}

			parking.receivingCar(car);

			canReturn = rd.nextInt(5);
			if (canReturn == 0 && parkedCars.size() > 4) {
				returnCars.add(parkedCars.get(rd.nextInt(parkedCars.size())));
			}

		} while (!(cars.isEmpty() && returnCars.isEmpty()));

		System.out.println(String.format("%s terminou seu trabalho.\n", name));
	}

	public String getName() {
		return name;
	}

	public Car getCar() {
		return car;
	}

	public boolean stop() {
		return !(cars.isEmpty() && returnCars.isEmpty());
	}
}
