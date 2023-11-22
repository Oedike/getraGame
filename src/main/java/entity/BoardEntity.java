package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ihm.GamePanel;
import ihm.KeyHandler;
import ihm.MouseHandler;

public class BoardEntity extends Entity{

	private GamePanel gp;
	private KeyHandler keyH;
	private MouseHandler mouseH;
	
	public BufferedImage table;
	
	public BoardEntity(GamePanel gp, KeyHandler keyH, MouseHandler mouseH) {
		super(keyH,mouseH);
		this.typeEntity = TYPE_ENTITY_BOARD;
		this.gp = gp;
		this.keyH = keyH;
		this.mouseH = mouseH;
		
		setDefaultValues();
		getBoardImage();
	}
	
	public void setDefaultValues() {

	}
	
	public void getBoardImage() {
		try {
			table = ImageIO.read(getClass().getResourceAsStream("/table/grass.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(table, 0, 0, gp.SCREEN_WIDTH, gp.SCREEN_HEIGHT, null);
	}
}
