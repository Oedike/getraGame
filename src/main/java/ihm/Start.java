package ihm;

import javax.swing.JFrame;

public class Start {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Test");

		GamePanel gamePanel = GamePanel.getInstance();
		window.add(gamePanel);

		window.pack();

		window.setLocationRelativeTo(null);;
		window.setVisible(true);

		gamePanel.startGameThread();
	}
}
