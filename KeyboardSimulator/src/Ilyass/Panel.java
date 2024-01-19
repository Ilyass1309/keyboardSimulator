 package Ilyass;

import java.awt.Color;
import java.awt.Graphics;

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
	
	public void onNewEyePosition(int x, int y) {
		setterCircleX(x);
		setterCircleY(y);
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawOval(circleX, circleY, GAZE_SIZE, GAZE_SIZE);
	}
}
