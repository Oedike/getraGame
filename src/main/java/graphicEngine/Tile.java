package graphicEngine;

import java.awt.Color;

public class Tile extends BaseCube {
	public Tile(int[] position2D,double cubeHeight , Color cubeColor) {
		super(new int[]{position2D[0],position2D[1],0},cubeHeight,cubeColor);
	};

}
