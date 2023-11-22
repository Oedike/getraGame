package graphicEngine;

import java.awt.image.BufferedImage;

import ihm.GraphicWrapper;

//import graphicEngine.GraphicAnimation;

public class GraphicObject {
	private double[] _game3DCoord;
	
	private double[] _true2DCoord;
	
	private BufferedImage _staticSprite;
	//private int _currentAnimation=-1;
	//private ArrayList<GraphicAnimation> _objAnimations;
	
	public GraphicObject(double[] game3DPos){
		_game3DCoord = game3DPos;
	};
	
	public void draw(GraphicWrapper graphicInfo, Camera camera) {
		
	};
}
