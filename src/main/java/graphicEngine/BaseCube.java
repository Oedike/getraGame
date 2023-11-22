package graphicEngine;

import java.awt.Color;
import java.awt.Graphics2D;

import graphicEngine.Camera;
import ihm.GraphicWrapper;
import utils.Mat;

public class BaseCube {
	
	private static final double _cubeLenght = 20;
	
	private double _cubeHeight;
	
	private static final double[][] unitCoord = {
			{Math.cos(Math.PI/8)	,-Math.cos(Math.PI/8)	,0		},
			{Math.sin(Math.PI/8)	,Math.sin(Math.PI/8)	,-1      }
	};

	private static final double[][]  faceLeft_Vertices = {
			{0,0,1,1},
			{1,1,1,1},
			{0,1,1,0}
	};
	
	private static final double[][]  faceUp_Vertices = {
			{1,1,0,0},
			{0,1,1,0},
			{1,1,1,1}
	};
	
	private static final double[][]  faceRight_Vertices = {
			{1,1,1,1},
			{0,1,1,0},
			{0,0,1,1}
	};
	
	private Color[] _facesColors; //left,up,right
	private int[] _game3DPos;
	
	private int[][] _trueVerticesCoordLeft;
	private int[][] _trueVerticesCoordUp;
	private int[][] _trueVerticesCoordRight;
	
	private double[][] faceLeft_2DCoord;
	private double[][] faceUp_2DCoord;
	private double[][] faceRight_2DCoord;
	
	public void setHeight(float heightMultiplier) {
		_cubeHeight = heightMultiplier;
	}
	
	public void changeColor(Color newColor) {
		_facesColors[0] = newColor;
		_facesColors[1] = newColor.darker();
		_facesColors[2] = _facesColors[0].darker();
	}
	
	public void changeColors(Color newColorUp, Color newColorLeft, Color newColorRight) {
		_facesColors[0] = newColorUp;
		_facesColors[1] = newColorLeft;
		_facesColors[2] = newColorRight;
	}
	
	public BaseCube(int[] game3DPosition,double cubeHeight , Color cubeColor) {
		
		_game3DPos = new int[3];
		this._game3DPos = game3DPosition;
		
		_facesColors = new  Color[3];
		_facesColors[0] = cubeColor;
		_facesColors[1] = cubeColor.darker();
		_facesColors[2] = _facesColors[1].darker();
		
		_trueVerticesCoordLeft= new int[2][4];
		_trueVerticesCoordUp= new int[2][4];
		_trueVerticesCoordRight= new int[2][4];
		
		_cubeHeight = cubeHeight;
		double[] heightVec = {1,1,_cubeHeight};
		
		faceUp_2DCoord= Mat.multiplyMatrices(unitCoord,Mat.offsetVertices(_game3DPos,  Mat.multiplyVec(heightVec, faceUp_Vertices)));
		faceLeft_2DCoord= Mat.multiplyMatrices(unitCoord,Mat.offsetVertices(_game3DPos, Mat.multiplyVec(heightVec, faceLeft_Vertices)));
		faceRight_2DCoord= Mat.multiplyMatrices(unitCoord,Mat.offsetVertices(_game3DPos,Mat.multiplyVec(heightVec, faceRight_Vertices)));
	}
	
	public BaseCube(int[] game3DPosition, Color[] facesColors) {
		this._facesColors = facesColors;
	}
	
	public boolean isVisible() {
		return true;
	}
	
	public void drawLeft(GraphicWrapper graphicInfo, Camera camera ) {
		if(!isVisible()) {return;}
		
		double viewportHeight = graphicInfo.windowSize.height;
		double viewportWidth = graphicInfo.windowSize.width;
		double[] cameraPos = camera.getPosition();
		
		graphicInfo.graphics.setColor(_facesColors[1]);
		
		_trueVerticesCoordLeft[0] = Mat.roundVector( Mat.incrementVector( (double) (viewportWidth/2.0) - cameraPos[0], Mat.multiplyVector(_cubeLenght*camera.getZoom(), faceLeft_2DCoord[0] )));
		_trueVerticesCoordLeft[1] = Mat.roundVector( Mat.incrementVector( (double) (viewportHeight/2.0) - cameraPos[1], Mat.multiplyVector(_cubeLenght*camera.getZoom(), faceLeft_2DCoord[1] )));
		graphicInfo.graphics.fillPolygon(_trueVerticesCoordLeft[0]  , _trueVerticesCoordLeft[1],4);
	}
	
	public void drawUp(GraphicWrapper graphicInfo, Camera camera ) {
		if(!isVisible()) {return;}
		
		double viewportHeight = graphicInfo.windowSize.height;
		double viewportWidth = graphicInfo.windowSize.width;
		double[] cameraPos = camera.getPosition();
		
		graphicInfo.graphics.setColor(_facesColors[0]);
		_trueVerticesCoordUp[0] = Mat.roundVector( Mat.incrementVector( (double) (viewportWidth/2.0) - cameraPos[0], Mat.multiplyVector(_cubeLenght*camera.getZoom(), faceUp_2DCoord[0])));
		_trueVerticesCoordUp[1] = Mat.roundVector( Mat.incrementVector( (double) (viewportHeight/2.0) - cameraPos[1], Mat.multiplyVector(_cubeLenght*camera.getZoom(), faceUp_2DCoord[1])));
		graphicInfo.graphics.fillPolygon(_trueVerticesCoordUp[0]  , _trueVerticesCoordUp[1],4);
		
	}

	public void drawRight(GraphicWrapper graphicInfo, Camera camera ) {
		if(!isVisible()) {return;}
		
		double viewportHeight = graphicInfo.windowSize.height;
		double viewportWidth = graphicInfo.windowSize.width;
		double[] cameraPos = camera.getPosition();
		
		graphicInfo.graphics.setColor(_facesColors[2]);
		_trueVerticesCoordRight[0] = Mat.roundVector( Mat.incrementVector( (double) (viewportWidth/2.0) - cameraPos[0], Mat.multiplyVector(_cubeLenght*camera.getZoom(), faceRight_2DCoord[0])));
		_trueVerticesCoordRight[1] = Mat.roundVector( Mat.incrementVector( (double) (viewportHeight/2.0) - cameraPos[1], Mat.multiplyVector(_cubeLenght*camera.getZoom(), faceRight_2DCoord[1])));
		graphicInfo.graphics.fillPolygon(_trueVerticesCoordRight[0]  , _trueVerticesCoordRight[1],4);
		
	}
	
	public void draw(GraphicWrapper graphicInfo, Camera camera ) {
		if(!isVisible()) {return;}
		
		drawLeft(graphicInfo,camera);
		drawRight(graphicInfo,camera);
		drawUp(graphicInfo,camera);
		
	}
}
