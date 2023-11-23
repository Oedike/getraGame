package BasicForm;

import java.awt.Color;
import java.awt.Graphics2D;

import graphicEngine.Camera;
import ihm.GraphicWrapper;
import utils.Mat;

public abstract class GraphicObject {
	
	private double[] _game3DPos;

	protected Face[] _faces;
	
	public GraphicObject(double[] game3DPosition, Face[] faces) {
		_game3DPos = game3DPosition;
		_faces=faces;
	}
	
	public boolean isVisible() {
		return true;
	}
}
