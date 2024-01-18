package fr.irit.elipse.keyboardsimulator.launcher;

import javax.swing.JFrame;

public class NewFrame extends JFrame{
	
	public NewFrame() {
		
		this.setTitle("Deeeessin");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocation(1200, 150);
        this.setResizable(true);
        
        //add JPanel 
        NewPanel panel = new NewPanel();
        this.getContentPane().add(panel);
        
        this.setVisible(true);
	}
}