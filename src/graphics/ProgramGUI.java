package graphics;


import javax.swing.*;

public class ProgramGUI extends javax.swing.JFrame {

	public ProgramGUI(){
		initialize();
	}

	private void initialize() {

		panel = new JPanel();
		parkingLbl = new JLabel();
		startBtn = new JButton();
		driverOneLbl = new JLabel();
		driverTwoLbl = new JLabel();
		driverThreeLbl = new JLabel();
		driverFourLbl = new JLabel();

		tempTextField = new JTextField();




		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("JubjubYeah Parking");
		setSize(800, 600);

		parkingLbl.setText("Iniciar expediente no JubjubYeah Parking:");
		parkingLbl.setLabelFor(startBtn);

		startBtn.setText("Iniciar");


		driverOneLbl.setText("João");
		driverOneLbl.setText("Pedro");
		driverOneLbl.setText("Diego");
		driverOneLbl.setText("Antônio");


		panel.add(parkingLbl);
		panel.add(startBtn);
		this.add(panel);
		//pack();
	}

	private JLabel parkingLbl;
	private JButton startBtn;
	private JPanel panel;
	private JLabel driverOneLbl;
	private JLabel driverTwoLbl;
	private JLabel driverThreeLbl;
	private JLabel driverFourLbl;

	private JTextField tempTextField;
}
