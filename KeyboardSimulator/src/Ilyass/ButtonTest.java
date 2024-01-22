package Ilyass;


import java.awt.Robot;

import java.awt.event.*;

import javax.swing.*;

import tobii.Tobii;

public class ButtonTest implements ActionListener{
	private final Timer timer;
	
	public ButtonTest() {
		
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
			int x = (int) position[0];
			int y = (int) position[1];
			Robot r = new Robot();
			
			r.mouseMove(x, y);
				
		} catch (Exception e2) {
			e.setSource(e2);
		}

	}
}
