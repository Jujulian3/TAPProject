package entities;

import java.util.Random;

public class Car {
	private String plate;
	private String letters = "";
	private String numbers = "";

	private String getLetters(int quantity){
		Random rd = new Random();
		char letter = (char)(rd.nextInt(26)+65);

		if (quantity == 1) { return letters = letters + letter;	}
		return letters + letter + getLetters(quantity-1);
	}

	private String getNumbers(int quantity){
		Random rd = new Random();
		int number = rd.nextInt(10);

		if (quantity == 1) { return numbers = numbers + number;	}
		return numbers + number + getNumbers(quantity-1);
	}

	public Car() {
		this.plate = String.format("%s-%s", getLetters(3), getNumbers(4));
	}

	public String getPlate() {
		return plate;
	}
}
