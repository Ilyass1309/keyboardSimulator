package fr.irit.elipse.keyboardsimulator.eyetracking;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.irit.elipse.keyboardsimulator.interfaces.EyeTracker;
import tobii.Tobii;

public class EyeTrackerIlyass extends JFrame{
	
	private JPanel panel;
	private int circleX, circleY;
	private EyeTracker tracker;
	
	public EyeTrackerIlyass() {
		
		panel = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawOval(circleX, circleY, 50, 50);
			}
		};
		
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
        setLocation(1200, 150);
	    setVisible(true);
	    
//	    tracker.setGUI(this);
	    
	    startEyeTracking();
	}
	
	private void startEyeTracking() {
		float[] position = 	Tobii.gazePosition();
		circleX = (int) position[0];
		circleY = (int) position[1];
		panel.repaint();
	}
}
