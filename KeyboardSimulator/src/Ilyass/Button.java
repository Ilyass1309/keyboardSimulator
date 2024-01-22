package Ilyass;
import java.awt.Robot;
import java.awt.TextField;
import java.awt.event.*;

import javax.swing.*;

import tobii.Tobii;

public class Button implements ActionListener{
	private final Timer timer;
//	private static TextField x, y, x1, y1;
	
	public Button() {
		
		timer = new Timer(20, this);
		timer.start();
	}
	
	public static void main(String[] args) {
		
		Button button = new Button();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JButton bA = new JButton();
//		JButton bB = new JButton();
//		JButton bC = new JButton();
		
		panel.add(bA);
//		panel.add(bB);
//		panel.add(bC);
		
		frame.setTitle("Test Button");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLocation(1200, 150);
		frame.setResizable(true);
		frame.setVisible(true);
		
		bA.addActionListener(button);
		
//		x = new TextField(7);
//		y = new TextField(7);
//		
//		x1 = new TextField(7);
//		y1 = new TextField(7);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			float[] position = Tobii.gazePosition();
			Robot r = new Robot();
//			int xi, yi, xi1, yi1;
			
//			xi = Integer.parseInt(x.getText());
//            yi = Integer.parseInt(y.getText());
//            xi1 = Integer.parseInt(x1.getText());
//            yi1 = Integer.parseInt(y1.getText());
            
            r.mouseMove( (int) position[0], (int) position[1]);
			
		} catch (Exception e2) {
			e.setSource(e2);
		}

	}
}
