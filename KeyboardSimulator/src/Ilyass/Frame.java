package Ilyass;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame{
	
	public Frame() {
		JFrame frame = new JFrame();
		frame.setTitle("Eye tracker données");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600, 600);
	    frame.setLocation(1200, 150);
	    frame.setResizable(true);
	    
	    JPanel panel = new JPanel();
	    frame.getContentPane().add(panel);
	    frame.setVisible(true);
	}
	
	public void paint(float circleX, float circleY) {
		System.out.println("coordonnées : x = " + circleX + " y = " + circleY);
	}
}
