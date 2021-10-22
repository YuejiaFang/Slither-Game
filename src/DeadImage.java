import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DeadImage extends JPanel {
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon deadimage = new ImageIcon("deadimage.png");
		deadimage.paintIcon(this, g, 600, 400);
	}


}
