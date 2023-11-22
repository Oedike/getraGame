package ihm;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import data.Card;
import data.Deck;
import data.Player;
import datamanager.DeckBuilder;
import entity.BoardEntity;
import entity.ButtonEntity;
import entity.Entity;
import entity.PlayerEntity;
import graphicEngine.BaseCube;
import graphicEngine.Board;
import graphicEngine.Camera;

public class GamePanel extends JPanel implements Runnable {

	private static GamePanel instance;
	private Deck deck;
	
	public static GamePanel getInstance() {
		if (instance == null) {
			instance = new GamePanel();
		}
		return instance;
	}
	
	public static final int SCREEN_WIDTH = 1900;
	public static final int SCREEN_HEIGHT = 1000;
	
	int FPS = 60;
	
	//TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	MouseHandler mouseH = new MouseHandler();
	Thread gameThread;
	//public CollisionChecker cChecker = new CollisionChecker(this);
	
	//public Player player = new Player(this,keyH);
	private BoardEntity board;
	
	private ButtonEntity validBtn;
	private PlayerEntity playerEntity;
	private Board _board;
	private Camera _camera;
	private GraphicWrapper graphicInfo;
	

	
	private GamePanel() {
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.addMouseListener(mouseH);
		this.setFocusable(true);
		
		board = new BoardEntity(this,keyH,mouseH);
		_camera = new Camera(keyH,mouseH);
		
		Player player = new Player(1);
		playerEntity = new PlayerEntity(this, keyH, mouseH, player){
			@Override
			public void onClickBtn() {
			}
		};
		
		int[] pos = {0,0,0};
		_board = new Board(50,50);
		
		
	}


	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		//int drawCount = 0;
		
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += currentTime-lastTime;
			
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
				//drawCount++;
			}
			if(timer >= 1000000000) {
//				System.out.println("FPS : " + drawCount);
				//drawCount = 0;
				timer = 0;
			}
		}
	}
	
	public void update() {
		//card.update();
		_camera.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		graphicInfo= new GraphicWrapper(g2, new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		
		//tileM.draw(g2);
		//board.draw(g2);
		
		_board.draw(graphicInfo,_camera);

		//validBtn.draw(g2);
		
		//playerEntity.draw(g2);
		
		//immeubleEntity.draw(g2);
		
		g2.dispose();
		
		
	}
}


