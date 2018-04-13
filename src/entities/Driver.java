package entities;

public class Driver {

	private String name;
	private int skill;
	private String car;

	public Driver(String name, int skill) {
	this.name = name;
	this.skill = 1000 * skill;
	}

	public void run() {
		//Aqui implementa o que o motorista vai fazer
	}
}
