import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	
	
	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	private int lengthofsnake = 3;
	
	private Timer timer;
	private Timer foodtimer;
	private int delay = 200;
	
	private ImageIcon snakeimage;
	
	private int moves = 0;
	
	private ImageIcon titleImage;
	
	private int [] foodx = {50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int [] foody = {50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
	private ImageIcon foodimage;
	private ImageIcon fastimage;
	private ImageIcon slowimage;
	private boolean sfood = false;
	private Random random = new Random();
	
	private int xpos1 = random.nextInt(33);
	private int xpos2 = random.nextInt(33);
	private int ypos1 = random.nextInt(23);
	private int ypos2 = random.nextInt(23);
	
	public Gameplay() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paint (Graphics g) {
		
		if (moves == 0) {
			snakexlength[2] = 50;
			snakexlength[1] = 75;
			snakexlength[0] = 100;
			
			snakeylength[2] = 100;
			snakeylength[1] = 100;
			snakeylength[0] = 100;
			
		}
		
		// draw title image border
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		// draw the tilte image
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//draw border for gameplay
		g.setColor(Color.WHITE);
		g.drawRect(24, 74, 851, 577);
		
		//draw background for the gameplay
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);
		
		for(int i = 0; i< lengthofsnake; i++) {
			if (i == 0 && right) {
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
			}
			if (i == 0 && left) {
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
			}
			if (i == 0 && down) {
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
			}
			if (i == 0 && up) {
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[i], snakeylength[i]);
			}
			
			if (i != 0) {
				snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakexlength[i], snakeylength[i]);
			}
		}
		
		
		foodimage = new ImageIcon("food.png");
		fastimage = new ImageIcon("fast.png");
		slowimage = new ImageIcon("slow.png");
		
		
		if ((foodx[xpos1] == snakexlength[0]) && foody[ypos1] == snakeylength[0]) {
			lengthofsnake++;
			xpos1 = random.nextInt(34);
			ypos1 = random.nextInt(23);
		}
		
		foodimage.paintIcon(this, g, foodx[xpos1], foody[ypos1]);
		
		if (sfood == true) {

			fastimage.paintIcon(this, g, foodx[xpos2], foody[ypos2]);
			sfood = false;
		}
		

		
		
		
		for(int i = 1; i <lengthofsnake; i++) {
			if ((snakexlength[i] == snakexlength[0] && snakeylength[i] == snakeylength[0]) || (snakexlength[i] >850 || snakexlength[i] < 50) || (snakeylength[i] > 600 || snakeylength[i] < 75) ) {
				right = false;
				left = false;
				up = false;
				down = false;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Game Over", 300, 300);
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Space to restart", 350, 320);
				
			}
		}
		
		g.dispose();
	}
	
//	public void Dead() {
//		DeadImage d = new DeadImage();
//		JFrame dead = new JFrame();
//		
//		dead.setBounds(10, 10,600,400);
//		dead.setBackground(Color.DARK_GRAY);
//		dead.setResizable(false);
//		dead.setVisible(true);
//		dead.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		dead.add(d);
//	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		timer.start();
		if (right) {
			for (int i = lengthofsnake-1; i >= 0; i--) {
				snakeylength[i+1] = snakeylength[i];
			}
			for (int i = lengthofsnake; i >= 0 ; i--) {
				if(i==0) {
					snakexlength[i] = snakexlength[i] +25;
				}
				else {
					snakexlength[i] = snakexlength[i-1];
				}
				
//				if(snakexlength[i] > 825) {
//					timer.stop();
////					Dead();
//				}
			}
			
			repaint();
			
			
		}
		if (left) {
			for (int i = lengthofsnake-1; i >= 0; i--) {
				snakeylength[i+1] = snakeylength[i];
			}
			for (int i = lengthofsnake; i >= 0 ; i--) {
				if(i==0) {
					snakexlength[i] = snakexlength[i] - 25;
				}
				else {
					snakexlength[i] = snakexlength[i-1];
				}
				
//				if(snakexlength[i] < 50) {
//					timer.stop();
//				}
			}
			
			repaint();
		}
		if (up) {
			for (int i = lengthofsnake-1; i >= 0; i--) {
				snakexlength[i+1] = snakexlength[i];
			}
			for (int i = lengthofsnake; i >= 0 ; i--) {
				if(i==0) {
					snakeylength[i] = snakeylength[i] - 25;
				}
				else {
					snakeylength[i] = snakeylength[i-1];
				}
				
//				if(snakeylength[i] < 100) {
//					timer.stop();
//				}
			}
			
			repaint();
		}
		if (down) {
			for (int i = lengthofsnake-1; i >= 0; i--) {
				snakexlength[i+1] = snakexlength[i];
			}
			for (int i = lengthofsnake; i >= 0 ; i--) {
				if(i==0) {
					snakeylength[i] = snakeylength[i] +25;
				}
				else {
					snakeylength[i] = snakeylength[i-1];
				}
				
//				if(snakeylength[i] > 600) {
//					timer.stop();
//				}
			}
			
			repaint();
		}
		
		
		if (lengthofsnake % 3 == 1 && lengthofsnake > 4 ) { 
			sfood = true;

		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			moves = 0;
			lengthofsnake = 3;
			repaint();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moves++;
			right = true;
			if (!left) {
				right = true;
			}
			else {
				right = false;
				left = true;
			}

			up = false;
			down = false;
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			moves++;
			left = true;
			if (!right) {
				left = true;
			}
			else {
				left = false;
				right = true;
			}

			up = false;
			down = false;
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			moves++;
			up = true;
			if (!down) {
				up = true;
			}
			else {
				up = false;
				down = true;
			}

			left = false;
			right = false;
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			moves++;
			down = true;
			if (!up) {
				down = true;
			}
			else {
				down = false;
				up = true;
			}

			left = false;
			right = false;
			
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
