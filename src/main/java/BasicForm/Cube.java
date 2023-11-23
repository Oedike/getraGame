package BasicForm;

import java.awt.Color;

public class Cube extends GraphicObject {
	private static final int[][]  faceLeft_Vertices = {
			{0,0,1,1},
			{1,1,1,1},
			{0,1,1,0}
	};
	
	private static final int[][]  faceUp_Vertices = {
			{1,1,0,0},
			{0,1,1,0},
			{1,1,1,1}
	};
	
	private static final int[][]  faceRight_Vertices = {
			{1,1,1,1},
			{0,1,1,0},
			{0,0,1,1}
	};
	
	public Cube(double[] cube3DPos, Color color) {
		super(	cube3DPos ,
				new Face[] {	
						new Face(faceUp_Vertices,cube3DPos,color),
						new Face(faceLeft_Vertices,cube3DPos,color.darker()),
						new Face(faceRight_Vertices,cube3DPos,color.darker().darker())
				});
	}
}
