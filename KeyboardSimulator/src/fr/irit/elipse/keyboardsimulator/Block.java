package fr.irit.elipse.keyboardsimulator;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Block extends Area{
	private String name;
	private ArrayList<Area> listOfChilds;
	private int currentChild;

	public Block() {
		listOfChilds = new ArrayList<Area>();
		init();
	}
	
	public Block(String name) {
		this.name = name;
		listOfChilds = new ArrayList<Area>();
		init();
	}
	
	public void createArea() {
		if(listOfChilds.size()>0) {
		
			name = "";
			Area a0 = listOfChilds.get(0);
			if(a0 instanceof Block)
				((Block)a0).createArea();
			double minX = a0.area.getX();
			double minY = a0.area.getY();
			double maxW = a0.area.getX()+a0.area.getWidth();
			double maxH = a0.area.getY()+a0.area.getHeight();
			for(Area a:listOfChilds){
				String key = "";
				if(a instanceof Block) {
					Block b = (Block)a;
					b.createArea();
					name += b.name;
				}else
					name += ((Key)a).getString();
				
				if(minX > a.area.getX())
					minX = a.area.getX();
				if(minY > a.area.getY())
					minY = a.area.getY();
				if(maxW < a.area.getX()+a.area.getWidth())
					maxW = a.area.getX()+a.area.getWidth();
				if(maxH < a.area.getY()+a.area.getHeight())
					maxH = a.area.getY()+a.area.getHeight();
			}
			area = new Rectangle2D.Double(minX-2, minY-2, maxW-minX+4, maxH-minY+4);
//			System.out.println(area);
		}
	}
	
	@Override
	public void init() {
		currentChild = -1;		
		for(Area a : listOfChilds)
			a.init();
	}
	
	public void addChild(Area a) {
		a.setParent(this);
		listOfChilds.add(a);
	}
	
	public Area getNextChild() {
		currentChild = (currentChild+1)%listOfChilds.size();
		return listOfChilds.get(currentChild);
	}
	
	public Area getCurrentChild() {
		return listOfChilds.get(currentChild);
	}

	@Override
	public void activate(){
		super.activate();
		sendInfo("[A](B)"+name);
	}
	
	@Override
	public void validate() {
		if(isActive()){
			sendInfo("[V](B)"+name);
			desactivate();
			getNextChild().activate();
		}else {
			getCurrentChild().validate();
		}
	}
	
	public void paint(Graphics2D g2) {
		if(area!=null) {
			if(isActive()){
				g2.setColor(Color.BLUE);
				g2.setStroke(new BasicStroke(2.0f));
			}else{
				g2.setColor(Color.BLACK);
				g2.setStroke(new BasicStroke(1.0f));
			}
			g2.draw(area);
		}
		for(Area a:listOfChilds)
			a.paint(g2);
	}

	public void sendInfo(String s) {
		Area b = getParent();
		while(b!=null && b.getParent()!=null)
			b=b.getParent();
		if(b!=null)
			b.sendInfo(s);
		else
			super.sendInfo(s);
	}	
	
	public String getName() {return name;}
}