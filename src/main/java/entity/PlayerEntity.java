package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import data.Card;
import data.Player;
import ihm.GamePanel;
import ihm.KeyHandler;
import ihm.MouseHandler;

public abstract class PlayerEntity extends Entity{

	protected GamePanel gp;
	protected KeyHandler keyH;
	protected MouseHandler mouseH;
	private Player player;
	private int posX;
	private int posY;
	private int height;
	private int width;

	
	public BufferedImage focus;
	
	public PlayerEntity(GamePanel gp, KeyHandler keyH, MouseHandler mouseH, Player player) {
		super(keyH, mouseH);
		this.typeEntity = TYPE_ENTITY_PLAYER;
		this.gp = gp;
		this.keyH = keyH;
		this.mouseH = mouseH;
		this.player = player;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
	}
	
	@Override
	public boolean isPointOnEntity(Point p) {
		if(((p.x > posX) && (p.x < (posX+width))) 
		&& (((p.y > posY) && (p.y < (posY+height))))){
			hasFocus = true;
			onClickBtn();
			/*for(int i = cardEntityList.size()-1; i>0;i--) {
				CardEntity ce = cardEntityList.get(i);
				if(ce.isPointOnEntity(p)) {
					return true;
				}
			}*/
			
			return true;
		}
		return false;
	}
	
	public void onClickBtn() {
		
	}
		
	public void setPosition(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setDimension(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	public void getPlayerImage() {
		try {
			focus = ImageIO.read(getClass().getResourceAsStream("/card/focus.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {

	}
	
	public void draw(Graphics2D g2) {

	}

	public Player getPlayer() {
		return player;
	}
}
