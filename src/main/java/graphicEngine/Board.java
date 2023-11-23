package graphicEngine;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import BasicForm.Cube;
import BasicForm.GraphicObject;
import entity.Entity;
import ihm.GraphicWrapper;

public class Board extends Entity{
	
	public Board(int width,int length) {
		super(null,null);
		
		_graphicObjects = new GraphicObject[width*length];
		for(int i=0; i<width;i++) {
			for(int j=0; j<length;j++) {
				double[] pos = {i,j,0};
				_graphicObjects[length*i+j] = new Cube(pos ,new Color(129,185,48));
			}
		}
		
		
		
		
	};
}
