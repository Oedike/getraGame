package entity;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import ihm.KeyHandler;
import ihm.MouseHandler;

public abstract class Entity {

	public static final int TYPE_UNKNOWN = 0;
	public static final int TYPE_ENTITY_BOARD = 1;
	public static final int TYPE_ENTITY_CARD = 2;
	public static final int TYPE_ENTITY_BUTTON = 3;
	public static final int TYPE_ENTITY_PLAYER = 4;
	public static final int TYPE_ENTITY_SCORE = 5;
	public static final int TYPE_ENTITY_IMMEUBLE = 6;
	
	protected boolean hasFocus;
	protected int typeEntity;
	
	protected KeyHandler _keyHandler;
	protected MouseHandler _mouseHandler;
	
	public Entity( KeyHandler keyH, MouseHandler mouseH) {
		_keyHandler = keyH;
		_mouseHandler = mouseH;
	};
	
	public boolean isPointOnEntity(Point p) {
		return false;
	}
	
	public void update() {
		
	}
	
	public void draw() {
		
	}
	
	public int getTypeEntity() {
		return typeEntity;
	}
}
