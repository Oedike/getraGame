package entity;

import ihm.KeyHandler;
import ihm.MouseHandler;

public abstract class Controllable {
	protected KeyHandler _keyHandler;
	protected MouseHandler _mouseHandler;
	
	public Controllable( KeyHandler keyH, MouseHandler mouseH) {
		_keyHandler = keyH;
		_mouseHandler = mouseH;
	};
	
	public void update() {
		
	};
}
