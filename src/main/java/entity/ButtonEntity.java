package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ihm.GamePanel;
import ihm.KeyHandler;
import ihm.MouseHandler;

public abstract class ButtonEntity extends Entity{

	protected GamePanel gp;
	protected KeyHandler keyH;
	protected MouseHandler mouseH;
	private String text;
	private int posX;
	private int posY;
	private int height;
	private int width;
	
	public BufferedImage buttonImg,focus;
	
	public ButtonEntity(GamePanel gp, KeyHandler keyH, MouseHandler mouseH, String text) {
		super(keyH,mouseH);
		this.typeEntity = TYPE_ENTITY_BUTTON;
		this.gp = gp;
		this.keyH = keyH;
		this.mouseH = mouseH;
		this.text = text;
		
		setDefaultValues();
		getBoardImage();
	}
	
	public void setDefaultValues() {
	}
	
	@Override
	public boolean isPointOnEntity(Point p) {
		if(((p.x > posX) && (p.x < (posX+width))) 
		&& (((p.y > posY) && (p.y < (posY+height))))){
			hasFocus = true;
			onClickBtn();
			return true;
		}
		return false;
	}
	
	public abstract void onClickBtn();
		
	public void setPosition(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setDimension(int height, int width) {
		this.height = height;
		this.width = width;
	}
	
	public void getBoardImage() {
		try {
			buttonImg = ImageIO.read(getClass().getResourceAsStream("/card/back_prerequis_4.png"));
			focus = ImageIO.read(getClass().getResourceAsStream("/card/focus.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(buttonImg, posX, posY, width, height, null);
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Arial", Font.PLAIN, 18));
		g2.drawString(text, posX + 10, posY + height/2+5);
		
		if(hasFocus) {
			g2.drawImage(focus, posX, posY, width, height, null);
		}
	}
}
