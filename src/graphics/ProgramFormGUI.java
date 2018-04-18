/*
 * Created by JFormDesigner on Sun Apr 15 14:15:26 GFT 2018
 */

package graphics;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import entities.ThreadDriver;
import net.miginfocom.swing.*;

/**
 * @author Juliane Cristina Silva
 */
public class ProgramFormGUI extends JFrame {
	public ProgramFormGUI() {
		initComponents();
	}

	private void restartBtnActionPerformed(ActionEvent e) {

	}

	private void startBtnActionPerformed(ActionEvent e) {
		td1 = new ThreadDriver(names[0]);
		td2 = new ThreadDriver(names[1]);	
		td3 = new ThreadDriver(names[2]);	
		td4 = new ThreadDriver(names[3]);	
		worker1.execute();						
		worker2.execute();						
		worker3.execute();						
		worker4.execute();	
		startBtn.setEnabled(false);
	}

	private void initComponents() {
		

		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Juliane Cristina Silva
		parkingLbl = new JLabel();
		startBtn = new JButton();
		driverOneLbl = new JLabel();
		driverOnePgb = new JProgressBar();
		carDriverOneLbl = new JLabel();
		driverTwoLbl = new JLabel();
		driverTwoPgb = new JProgressBar();
		carDriverTwoLbl = new JLabel();
		driverThreeLbl = new JLabel();
		driverThreePgb = new JProgressBar();
		carDriverThreeLbl = new JLabel();
		driverFourLbl = new JLabel();
		driverFourPgb = new JProgressBar();
		carDriverFourLbl = new JLabel();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("JubjubYeah Parking");
		setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"hidemode 3",
			// columns
			"[5:10,fill]" +
			"[50:50,fill]" +
			"[280:280,fill]" +
			"[50:50,fill]" +
			"[5:10,fill]",
			// rows
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]" +
			"[]"));

		//---- parkingLbl ----
		parkingLbl.setText("Iniciar expediente no JubjubYeah Parking:");
		parkingLbl.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		contentPane.add(parkingLbl, "cell 2 1");

		//---- startBtn ----
		startBtn.setText("Iniciar");
		startBtn.addActionListener(e -> startBtnActionPerformed(e));
		contentPane.add(startBtn, "cell 2 2");

		//---- driverOneLbl ----
		driverOneLbl.setText("Motorista");
		driverOneLbl.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		contentPane.add(driverOneLbl, "cell 1 4");
		contentPane.add(driverOnePgb, "cell 2 4");

		//---- carDriverOneLbl ----
		carDriverOneLbl.setText("Carro");
		carDriverOneLbl.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		contentPane.add(carDriverOneLbl, "cell 3 4");

		//---- driverTwoLbl ----
		driverTwoLbl.setText("Motorista");
		driverTwoLbl.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		contentPane.add(driverTwoLbl, "cell 1 5");
		contentPane.add(driverTwoPgb, "cell 2 5");

		//---- carDriverTwoLbl ----
		carDriverTwoLbl.setText("Carro");
		carDriverTwoLbl.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		contentPane.add(carDriverTwoLbl, "cell 3 5");

		//---- driverThreeLbl ----
		driverThreeLbl.setText("Motorista");
		driverThreeLbl.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		contentPane.add(driverThreeLbl, "cell 1 6");
		contentPane.add(driverThreePgb, "cell 2 6");

		//---- carDriverThreeLbl ----
		carDriverThreeLbl.setText("Carro");
		carDriverThreeLbl.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		contentPane.add(carDriverThreeLbl, "cell 3 6");

		//---- driverFourLbl ----
		driverFourLbl.setText("Motorista");
		driverFourLbl.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		contentPane.add(driverFourLbl, "cell 1 7");
		contentPane.add(driverFourPgb, "cell 2 7");

		//---- carDriverFourLbl ----
		carDriverFourLbl.setText("Carro");
		carDriverFourLbl.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		contentPane.add(carDriverFourLbl, "cell 3 7");
		setSize(450, 300);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents

		driverOneLbl.setText(names[0]);
		driverTwoLbl.setText(names[1]);
		driverThreeLbl.setText(names[2]);
		driverFourLbl.setText(names[3]);
		carDriverOneLbl.setText("Inativo");
		carDriverTwoLbl.setText("Inativo");
		carDriverThreeLbl.setText("Inativo");
		carDriverFourLbl.setText("Inativo");
		
		worker1 = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				int spot = td1.getCar().getSpot() * 10 + ratio;
				do {
					driverOnePgb.setValue(0);
					driverOnePgb.setString("0%");
					carDriverOneLbl.setText(td1.getCar().getPlate());
					carDriverOneLbl.setForeground(td1.getCar().isParked() ? Color.RED : Color.BLACK);
					for (int i = 0; i <= 100; i++) {
						try {							
							driverOnePgb.setValue(i);
							driverOnePgb.setString(i + "%");
							driverOnePgb.setStringPainted(true);
							Thread.sleep(spot);
						} catch (InterruptedException ex) {	ex.printStackTrace(); }
					}
				} while (td1.stop());				
				return 0;
			}
			
			@Override
			protected void done() {
				carDriverOneLbl.setText("Finalizado");
				super.done();
			}
		};
		
		worker2 = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {						
				int spot = td2.getCar().getSpot() * 10 + ratio;
				do {
					driverTwoPgb.setValue(0);
					driverTwoPgb.setString("0%");
					carDriverTwoLbl.setText(td2.getCar().getPlate());
					carDriverTwoLbl.setForeground(td1.getCar().isParked() ? Color.RED : Color.BLACK);
					for (int i = 0; i <= 100; i++) {
						try {							
							driverTwoPgb.setValue(i);
							driverTwoPgb.setString(i + "%");
							driverTwoPgb.setStringPainted(true);
							Thread.sleep(spot);
						} catch (InterruptedException ex) {	ex.printStackTrace(); }
					}
				} while (td2.stop());
				return 0;
			}
			
			@Override
			protected void done() {
				carDriverTwoLbl.setText("Finalizado");
				super.done();
			}
		};
		
		worker3 = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {
				int spot = td3.getCar().getSpot() * 10 + ratio;
				do {
					driverThreePgb.setValue(0);
					driverThreePgb.setString("0%");
					carDriverThreeLbl.setText(td3.getCar().getPlate());
					carDriverThreeLbl.setForeground(td1.getCar().isParked() ? Color.RED : Color.BLACK);
					for (int i = 0; i <= 100; i++) {
						try {							
							driverThreePgb.setValue(i);
							driverThreePgb.setString(i + "%");
							driverThreePgb.setStringPainted(true);
							Thread.sleep(spot);
						} catch (InterruptedException ex) {	ex.printStackTrace(); }
					}
				} while (td3.stop());
				return 0;
			}
			
			@Override
			protected void done() {
				carDriverThreeLbl.setText("Finalizado");
				super.done();
			}
		};
		
		worker4 = new SwingWorker() {
			@Override
			protected Object doInBackground() throws Exception {	
				int spot = td4.getCar().getSpot() * 10 + ratio;
				do {
					driverFourPgb.setValue(0);
					driverFourPgb.setString("0%");
					carDriverFourLbl.setText(td4.getCar().getPlate());
					carDriverFourLbl.setForeground(td1.getCar().isParked() ? Color.RED : Color.BLACK);
					for (int i = 0; i <= 100; i++) {
						try {							
							driverFourPgb.setValue(i);
							driverFourPgb.setString(i + "%");
							driverFourPgb.setStringPainted(true);
							Thread.sleep(spot);
						} catch (InterruptedException ex) {	ex.printStackTrace(); }
					}
				} while (td4.stop());			
				return 0;
			}
			
			@Override
			protected void done() {
				carDriverFourLbl.setText("Finalizado");
				super.done();
			}
		};
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Juliane Cristina Silva
	private JLabel parkingLbl;
	private JButton startBtn;
	private JLabel driverOneLbl;
	private JProgressBar driverOnePgb;
	private JLabel carDriverOneLbl;
	private JLabel driverTwoLbl;
	private JProgressBar driverTwoPgb;
	private JLabel carDriverTwoLbl;
	private JLabel driverThreeLbl;
	private JProgressBar driverThreePgb;
	private JLabel carDriverThreeLbl;
	private JLabel driverFourLbl;
	private JProgressBar driverFourPgb;
	private JLabel carDriverFourLbl;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	private String[] names = {"João", "Pedro", "Diego", "Antônio"};
	private SwingWorker worker1;
	private SwingWorker worker2;
	private SwingWorker worker3;
	private SwingWorker worker4;
	private ThreadDriver td1;
	private ThreadDriver td2;
	private ThreadDriver td3;
	private ThreadDriver td4;
	private final int ratio = 100;
}
