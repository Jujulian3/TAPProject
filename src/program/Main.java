package program;

import entities.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {

		Random rd = new Random();

		Park park = new Park(rd.nextInt(100));
		Driver d1 = new Driver("João", rd.nextInt(100), park);
		Driver d2 = new Driver("Pedro", rd.nextInt(100), park);
		Driver d3 = new Driver("Diego", rd.nextInt(100), park);
		Driver d4 = new Driver("Antônio", rd.nextInt(100), park);

		List<Car> cars = new ArrayList<Car>();
		for (int i = 0; i < (rd.nextInt(100)); i++) {
			cars.add(new Car());
			System.out.println(String.format("o Carro %s chegou ao estacionamento!", cars.get(i).getPlate()));
		}

		for (int i = 0; i < cars.size(); i++){
			if(isAlreadyParked(cars.get(i).getPlate(), park.getParking())) {

			} else {

			}
		}



	}

	private static boolean isAlreadyParked(String carPlate, ParkingSpace[] parking){
		boolean result = false;

		for (int i = 0; i < parking.length; i++) {
			if (parking[i].getCarPlate().equals(carPlate)) {
				result = true;
				break;
			}
		}
		System.out.println(String.format("O dono do carro {0} voltou para buscá-lo, seu atendimento será priorizado.", carPlate));
		return result;
	}

}
