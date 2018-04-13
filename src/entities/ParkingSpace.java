package entities;

public class ParkingSpace {

	private int id;
	private String street;
	private String carPlate;

	public ParkingSpace(int id, char sector) {
		this.id = id;
		this.street = String.format("Rua do Setor-%s, nº %s", sector, id);
		this.carPlate = "";
	}

	public int getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getCarPlate() {
		return carPlate;
	}

	public void setCarPlate(String carPlate) {
		this.carPlate = carPlate;
	}

	public boolean isFree() {
		return this.carPlate != "" ? true : false;
	}
}
