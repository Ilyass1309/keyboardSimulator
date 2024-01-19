package Ilyass;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import tobii.Tobii;

public class EyeTrackerApp implements ActionListener{
	private final Timer timer;
	private float circleX, circleY;
	private Frame frame;
	
	public EyeTrackerApp() {
		
		frame = new Frame();
		circleX = circleY = 0;
		timer = new Timer(20, this);
		timer.start();
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        float[] position = Tobii.gazePosition();
        circleX = position[0]; 
        circleY = position[1];
        frame.paint(circleX, circleY);
        
    }
	
	public static void main(String[] args) {
		
		EyeTrackerApp eyeTracker = new EyeTrackerApp();
	}
	
}
