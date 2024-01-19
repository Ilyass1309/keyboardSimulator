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
	private int circleX;
	private int circleY;
	private Panel panel;
	
	public EyeTrackerApp() {
		
		JFrame frame = new JFrame();
		frame.setTitle("Test eyeTracker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLocation(1200, 150);
		frame.setResizable(true);
		frame.setVisible(true);
		
		circleX = circleY = 0;
		panel = new Panel();
		frame.getContentPane().add(panel);
	    frame.setVisible(true); 
		timer = new Timer(20, this);
		timer.start();
		
	}
	
	private void setterCircleX(int x) {
		this.circleX = x;

	}
	
	private void setterCircleY(int y) {
		this.circleY = y;

	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        float[] position = Tobii.gazePosition();
        System.out.println("x = " + position[0] + " y = " + position[1]);
//        setterCircleX((int)position[0]);
//        setterCircleY((int) position[1]);
//        panel.onNewEyePosition(circleX, circleY);
        
    }
	
	public static void main(String[] args) {
		
		EyeTrackerApp eyeTracker = new EyeTrackerApp(); 
	}
	
} 
