package program;

import entities.*;
import graphics.ProgramGUI;

public class Main {
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ProgramGUI().setVisible(true);
			}
		});

		//ThreadDriver d1 = new ThreadDriver("João");
		//ThreadDriver d2 = new ThreadDriver("Pedro");
		//ThreadDriver d3 = new ThreadDriver("Diego");
		//ThreadDriver d4 = new ThreadDriver("Antônio");
	}
}
