package BasicForm;

import java.awt.Color;

import utils.Mat;

public class Face {
	
	protected Color _faceColor;
	protected int[][] _trueVerticesCoord;
	protected double[][] _face_Vertices;
	protected double[][] _face_2DCoord;
	protected int _faceNumber;
	
	protected Face(int[][]  face_Vertices, double[] object3DPos , Color faceColor) {
		_face_Vertices= Mat.offsetVertices(object3DPos, face_Vertices);
		_faceColor=faceColor;
	}
}
