package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right;
	public static Keyboard defKeyboard = new Keyboard();

	public void update() {
		up = keys[KeyEvent.VK_UP];
		left = keys[KeyEvent.VK_LEFT];
		down = keys[KeyEvent.VK_DOWN];
		right = keys[KeyEvent.VK_RIGHT];
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;

	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}

	public void keyTyped(KeyEvent e) {

	}



}
