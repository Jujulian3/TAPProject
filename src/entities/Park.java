package entities;


public class Park {

	private ParkingSpace[] parking;
	private char sector = 65;

	public Park(int spaces){
		this.parking = new ParkingSpace[spaces];

		for (int i = 0; i < spaces; i++) {
			int index = 10;

			if (i > index) {
				index += 10;
				sector++;
			}
			this.parking[i] = new ParkingSpace(i+1,sector);
		}
	}

	public ParkingSpace[] getParking() {
		return parking;
	}

	public void setParking(ParkingSpace[] parking) {
		this.parking = parking;
	}
}
