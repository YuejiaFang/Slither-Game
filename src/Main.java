import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame obj = new JFrame();
		Gameplay gameplay = new Gameplay();
		
		
		obj.setBounds(10, 10,905,700);
		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
		

//		JFrame dead = new JFrame();
//		dead.setBounds(10, 10,600,400);
//		dead.setBackground(Color.DARK_GRAY);
//		dead.setResizable(false);
//		dead.setVisible(true);
//		dead.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
