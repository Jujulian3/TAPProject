package entities;


public class Driver extends Thread {

	private String name;
	private int skill;
	private Park park;

	public Driver(String name, int skill, Park park) {
		this.name = name;
		this.skill = 1000 * skill;
		this.park = park;
	}

	private void parkingCar(Car car) {
		ParkingSpace[] parking = park.getParking();
		int address = 0;

		for (int i = 0; i < parking.length; i++) {
			if (parking[i].isFree()) {
				parking[i].setCarPlate(car.getPlate());
				car.setParked(true);
				address = i;
				break;
			}
		}
		System.out.println(String.format("O motorista %s estacionou o carro %s na %s.",
				name, car.getPlate(), parking[address].getStreet()));
	}

	private void gettingCar(Car car) {
		ParkingSpace[] parking = park.getParking();
		int address = 0;

		for (int i = 0; i < parking.length; i++) {
			if (parking[i].getCarPlate().equals(car.getPlate())) {
				parking[i].setCarPlate("");
				car.setParked(false);
				break;
			}
		}
		System.out.println(String.format(
				"O motorista %s devolveu o carro %s estacionado na %s.",
				name, car.getPlate(), parking[address].getStreet()));
	}

	public void run(Car car) {
		//Aqui implementa o que o motorista vai fazer
		try {
			if (car.isParked()) {
				gettingCar(car);
			} else {
				parkingCar(car);
			}
			Thread.sleep(this.skill);

		} catch (InterruptedException e) {
			System.out.println(String.format("O motorista %s teve problemas com o carro %s.", name, car.getPlate()));
		}
	}
}
