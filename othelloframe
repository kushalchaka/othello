package game;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;

public class OthelloPanel extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OthelloFrame frame = new OthelloFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OthelloFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new OthelloPanel());
		this.setLocation(300, 0);
		this.setTitle("Othello");
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/images/custom_java_icon.jpg"));
		this.pack();
		
	}

}

