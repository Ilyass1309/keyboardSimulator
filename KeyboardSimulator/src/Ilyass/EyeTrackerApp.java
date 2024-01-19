package Ilyass;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import tobii.Tobii;

public class EyeTrackerApp extends JFrame implements ActionListener{
	private final Timer timer;
	private int circleX, circleY;
	private Panel panel;
	
	public EyeTrackerApp() {
		
		JFrame frame = new JFrame();
		circleX = circleY = 0;
		panel = new Panel();
		frame.getContentPane().add(panel);
	    frame.setVisible(true);
		timer = new Timer(20, this);
		timer.start();
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        float[] position = Tobii.gazePosition();
        circleX = (int) position[0]; 
        circleY = (int) position[1];
        panel.onNewEyePosition(circleX, circleY);
        
    }
	
	public static void main(String[] args) {
		
		EyeTrackerApp eyeTracker = new EyeTrackerApp(); 
	}
	
} 
