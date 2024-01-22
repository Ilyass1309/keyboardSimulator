 package Ilyass;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private static final int GAZE_SIZE = 50;
	private int circleX;
	private int circleY;
	
	public Panel() {
	    circleX = circleY = 0;
	}
	
	private void setterCircleX(int x) {
		circleX = x;
	}
	
	private void setterCircleY(int y) {
		circleY = y;
	}
	
	public void onNewEyePosition(float x, float y) {
		
		// à revoir
        // Convert from values between 0 and 1 to pixels on the screen
        Dimension dims = Toolkit.getDefaultToolkit().getScreenSize(); 
		setterCircleX((int) (x * dims.getWidth()));
		setterCircleY((int) (y * dims.getHeight()));
	
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawOval(circleX, circleY, GAZE_SIZE, GAZE_SIZE);
	}
}
