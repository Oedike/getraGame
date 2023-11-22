package graphicEngine;

import entity.Entity;
import ihm.KeyHandler;
import ihm.MouseHandler;
//import ihm.GraphicWrapper;

public class Camera extends Entity {
	
	//private GraphicWrapper _graphicInfo;
	
	private double[] _position = {0,0};
	
	private float _zoom = 1;
	
	private static float _cameraSpeed = 1 ;
	
	public Camera(KeyHandler keyH, MouseHandler mouseH/*, GraphicWrapper graphicInfo*/) {
		super(keyH,mouseH);
		//_graphicInfo = graphicInfo;
	}
	
	public double[] getPosition() {
		return _position;
	}
	
	public double getZoom() {
		return _zoom;
	}
	
	@Override
	public void update() {
		if(super._keyHandler.leftPressed) { _position[0] -= _cameraSpeed*50;}
		if(super._keyHandler.rightPressed) { _position[0] += _cameraSpeed*50;}
		if(super._keyHandler.downPressed) { _position[1] += _cameraSpeed*50;}
		if(super._keyHandler.upPressed) { _position[1] -= _cameraSpeed*50;}
		
		
	}
}
