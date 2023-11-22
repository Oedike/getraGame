package ihm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GraphicWrapper {
	public Graphics2D graphics;
	public Dimension windowSize;
	
	public GraphicWrapper(Graphics2D graph, Dimension windowSize) {
		this.graphics=graph;
		this.windowSize=windowSize;
	}
	
	public Graphics2D getGraphic() {
		return graphics;
	};
	
	public Dimension getWindowSize() {
		return windowSize;
	};
}
