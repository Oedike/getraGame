package ihm;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import entity.Entity;

public class MouseHandler implements MouseListener{

	private int X;
	private int Y;
	private Point point = new Point();
	
	
	public void mouseClicked(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
		point.x = e.getX();
		point.y = e.getY();
		System.out.println(X +" " + Y);
		
		//TODO donner dans le constructeur le deckbuilder ? pour savoir quelle carte est cliqué ?
		//faire une hasfocus de la carte et dessiner un contour si c'est le cas ?
		
		
		/*for (Entity entity : entityList) {
			boolean isSelected = entity.isPointOnEntity(point);
			if(isSelected) {
				if(entity.getTypeEntity() == Entity.TYPE_ENTITY_CARD) {;
				}
			}
		}*/
		if(e.getClickCount() >= 2) {
			System.out.println("Choisi !");
		}
		
	}

	public void mousePressed(MouseEvent e) {
		
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Point getPoint() {
		return point;
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
}
