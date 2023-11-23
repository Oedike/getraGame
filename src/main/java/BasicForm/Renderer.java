package BasicForm;

import entity.Entity;
import graphicEngine.Camera;
import ihm.GraphicWrapper;
import utils.Mat;

public class Renderer {
	
	GraphicWrapper _graphicInfo;
	Camera _camera;
	
	public Renderer(GraphicWrapper graphicInfo, Camera camera) {
		_graphicInfo=graphicInfo;
		_camera=camera;
		
		
	}
	
	public void setGraphic(GraphicWrapper graphicInfo) {
		_graphicInfo=graphicInfo;
	}
	
	public void draw(GraphicObject object) {
		for(int i=0;i<object._faces.length;i++) {
			drawFace(object._faces[i]);
		}
	}
	
	public void draw(Entity entity) {
		GraphicObject[] entityGraphics = entity.getGraphicObjects();
		for(int i=0;i<entityGraphics.length;i++) {
			draw(entityGraphics[i]);
		}
	}
	
	private void drawFace(Face face) {
		double viewportHeight = _graphicInfo.windowSize.height;
		double viewportWidth = _graphicInfo.windowSize.width;
		double[] cameraPos = _camera.getPosition();
		
		double[][] _trueVerticesMat = Mat.multiplyMatrices(_camera.getCameraProjectionMat(), face._face_Vertices);
		
		int[] faceTrueVerticesX = Mat.roundVector( Mat.incrementVector( (double) (viewportWidth/2.0) - cameraPos[0], _trueVerticesMat[0]));
		int[] faceTrueVerticesY = Mat.roundVector( Mat.incrementVector( (double) (viewportHeight/2.0) - cameraPos[1], _trueVerticesMat[1]));
		
		_graphicInfo.graphics.setColor(face._faceColor);
		_graphicInfo.graphics.fillPolygon(faceTrueVerticesX , faceTrueVerticesY, faceTrueVerticesX.length);
	}
}
