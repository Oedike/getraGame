package graphicEngine;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import entity.Entity;
import graphicEngine.BaseCube;
import ihm.GraphicWrapper;

public class Board extends Entity{
	private BaseCube[][] boardTiles;
	
	public Board(int width,int length) {
		super(null,null);
		//double maxHeight=1.5;
		//double minHeight=0.5;
		
		boardTiles = new BaseCube[width][length];
		for(int i=0; i<width;i++) {
			for(int j=0; j<length;j++) {
				int[] pos = {i,j,0};
				//double randomHeight = Math.floor(Math.random() *(maxHeight - minHeight + 1) + minHeight);
				boardTiles[i][j] = new BaseCube(pos,1 ,new Color(129,185,48));
			}
		}
		
		
		
		
	};
	
	public void draw(GraphicWrapper graphicInfo,Camera camera) {
		for(int i=0; i<boardTiles.length;i++) {
			for(int j=0; j<boardTiles[0].length;j++) {
				boardTiles[i][j].draw(graphicInfo,camera);
			}
		}
	};
	
}
