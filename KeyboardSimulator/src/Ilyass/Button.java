package Ilyass;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.TextField;
import java.awt.event.*;

import javax.swing.*;

import tobii.Tobii;

public class Button implements ActionListener{
//	private final Timer timer;
	private static TextField x_end, y_end;
	
	public Button() {
		
//		timer = new Timer(20, this);
//		timer.start();
	}
	
	public static void main(String[] args) {
		
		Button button = new Button();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		
		x_end = new TextField(7);
		y_end = new TextField(7);
		
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

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			Point p = MouseInfo.getPointerInfo().getLocation();
			int x_start = p.x;
			int y_start = p.y;
//			float[] position = Tobii.gazePosition();
			Robot r = new Robot();
			
            int i = x_start;
            int j = y_start;
            
            int xi1 = Integer.parseInt(x_end.getText());
            int yi1 = Integer.parseInt(y_end.getText());
            
			while (i != xi1 || j != yi1) {
                // move the mouse to the other point
                r.mouseMove(i, j);
 
                if (i < xi1)
                    i++;
                if (j < yi1)
                    j++;
 
                if (i > xi1)
                    i--;
                if (j > yi1)
                    j--;
 
                // wait
                Thread.sleep(30);
            }
			
		} catch (Exception e2) {
			e.setSource(e2);
		}

	}
}
