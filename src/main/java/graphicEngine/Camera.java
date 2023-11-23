package graphicEngine;

import java.awt.Dimension;

import entity.Controllable;
import entity.Entity;
import ihm.KeyHandler;
import ihm.MouseHandler;
import utils.Mat;
//import ihm.GraphicWrapper;

public class Camera extends Controllable {
	
	//private GraphicWrapper _graphicInfo;
	
	
	private static final double[][] unitCoord = {
			{Math.cos(Math.PI/8)	,-Math.cos(Math.PI/8)	,0		},
			{Math.sin(Math.PI/8)	,Math.sin(Math.PI/8)	,-1      }
	};
	
	private static int _blockPixeHeight = 32;
	
	private double[] _position = {0,0};
	
	private double _zoomCoef = 1;
	
	private Dimension _viewPortDimension;
	
	private double[][] _scaledUnitCoord = Mat.multiplyMatrix(_blockPixeHeight*_zoomCoef, unitCoord);
	
	private static double _cameraSpeed = 1 ;
	
	public Camera(KeyHandler keyH, MouseHandler mouseH, Dimension viewPortDimension) {
		super(keyH,mouseH);
		_viewPortDimension=viewPortDimension;
		//_graphicInfo = graphicInfo;
	}
	
	public void updatePosition(double[] newPos) {
		_position=newPos;
		
	}
	
	public double[] getPosition() {
		return _position;
	}
	
	public double getZoom() {
		return _zoomCoef;
	}
	
	public void setZoom(double newZoomCoef) {
		_zoomCoef = newZoomCoef;
		_scaledUnitCoord = Mat.multiplyMatrix(_blockPixeHeight*_zoomCoef, unitCoord);
	}
	
	public double[][] getCameraProjectionMat(){
		return _scaledUnitCoord;
	}

	@Override
	public void update() {
		if(super._keyHandler.leftPressed) { _position[0] -= _cameraSpeed*50;}
		if(super._keyHandler.rightPressed) { _position[0] += _cameraSpeed*50;}
		if(super._keyHandler.downPressed) { _position[1] += _cameraSpeed*50;}
		if(super._keyHandler.upPressed) { _position[1] -= _cameraSpeed*50;}
	}
}
