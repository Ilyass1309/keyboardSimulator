 package Ilyass;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private final int GAZE_SIZE = 50;
	private Graphics g;
	private int circleX, circleY;
	
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
		setterCircleX((int) x);
		setterCircleY((int) y);
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawOval(circleX, circleY, GAZE_SIZE, GAZE_SIZE);
	}
}
