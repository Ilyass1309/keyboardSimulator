package Ilyass;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

import tobii.Tobii;

public class ButtonTest implements ActionListener{
	private final Timer timer;
	private MoyenneMobile moyenneX;
	private MoyenneMobile moyenneY;
	
	public ButtonTest() {
		
		moyenneX = new MoyenneMobile(8);
		moyenneY = new MoyenneMobile(8);
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JButton bA = new JButton();	
		panel.add(bA);

		frame.setTitle("Test Button");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLocation(1200, 150);
		frame.setResizable(true);
		frame.setVisible(true);
		
		bA.addActionListener(this);
		
		timer = new Timer(1000, this);
		timer.start();
	}
	
	public static void main(String[] args) {
		
		ButtonTest button = new ButtonTest();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			float[] position = Tobii.gazePosition();
			float x = moyenneX.filtre(position[0]);
			float y = moyenneY.filtre(position[1]);
			
			// Conversion des valeurs en float entre 0 et 1 en pixels sur l'écran
			Dimension dims = Toolkit.getDefaultToolkit().getScreenSize();
	        int eyeX = (int) (x * dims.getWidth());
	        int eyeY = (int) (y * dims.getHeight());
			Robot r = new Robot();
			
			r.mouseMove(eyeX, eyeY);
				
		} catch (Exception e2) {
			e.setSource(e2);
		}

	}
}
