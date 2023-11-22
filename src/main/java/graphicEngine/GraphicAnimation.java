package graphicEngine;

import java.awt.image.BufferedImage;

public class GraphicAnimation {
	private BufferedImage[] _animationFrames;
	private int _currentFrame=0;
	
	protected boolean isAnimationDone() {
		return (_currentFrame==_animationFrames.length -1);
	}
	
	protected BufferedImage playStart() {
		_currentFrame=0;
		return _animationFrames[_currentFrame];
	}
	
	protected BufferedImage getNextFrame() {
		_currentFrame++;
		if(_currentFrame==_animationFrames.length) {
			_currentFrame=0;
		}
		return _animationFrames[_currentFrame];
	};
	
	protected BufferedImage getCurrentFrame() {
		return _animationFrames[_currentFrame];
	}
	
}
