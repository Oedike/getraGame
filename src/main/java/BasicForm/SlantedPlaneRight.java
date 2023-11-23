package BasicForm;

import java.awt.Color;

public class SlantedPlaneRight extends GraphicObject {
	private static final int[][]  face1_Vertices = {
			{0,1,0},
			{1,1,1},
			{0,0,1},
	};
	
	private static final int[][]  face2_Vertices = {
			{0,1,1,0},
			{1,1,0,1},
			{1,0,0,0}
	};	
	
	public SlantedPlaneRight(double[] cube3DPos, Color color) {
		super(	cube3DPos ,
				new Face[] {	
						new Face(face1_Vertices,cube3DPos,color),
						new Face(face2_Vertices,cube3DPos,color.darker())
				});
	}
}