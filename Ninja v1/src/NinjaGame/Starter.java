package NinjaGame;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class Starter extends Applet implements Runnable , KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int room = 1;
	private boolean playerIsAlive;
	Ninja ninja = new Ninja();
	private Image image, character;
	private Graphics second;
	private URL base;
	
	@Override
	public void init(){
		 setSize(800, 480);
		  setBackground(Color.WHITE);
	      setFocusable(true);
	      Frame frame = (Frame) this.getParent().getParent();
	      frame.setTitle("Q-Bot Alpha");
	      addKeyListener(this);
	      try {
				base = getDocumentBase();
			} catch (Exception e) {
				// TODO: handle exception
			}

			// Image Setups
			character = getImage(base, "data/character.png");
	}
	 @Override
	   public void start() {
	      Thread thread = new Thread(this);
	      thread.start();
	   } 
	 	@Override
	 	public void stop() {
		   // TODO Auto-generated method stub
		   }

		  @Override
		   	public void destroy() {
			  // TODO Auto-generated method stub
		   	}

		   @Override
		   public void run() {
			   while (true) {
			ninja.update();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		   @Override
			public void update(Graphics g) {
				if (image == null) {
					image = createImage(this.getWidth(), this.getHeight());
					second = image.getGraphics();
				}


				second.setColor(getBackground());
				second.fillRect(0, 0, getWidth(), getHeight());
				second.setColor(getForeground());
				paint(second);


				g.drawImage(image, 0, 0, this);

				
			}

			@Override
			public void paint(Graphics g) {
				g.drawImage(character, ninja.getCenterX() - 31, ninja.getCenterY() - 23, this);

			}
	public void keyPressed(KeyEvent e){
		  switch (e.getKeyCode()) {

	        case KeyEvent.VK_LEFT:
		            	ninja.moveLeft();
	            break;

	        case KeyEvent.VK_RIGHT:
	            	ninja.moveRight();
	            break;

	        case KeyEvent.VK_UP:
	            ninja.jump();
	            break;

	        }
	}
public void keyReleased(KeyEvent e){
	 switch (e.getKeyCode()) {
	 	case KeyEvent.VK_LEFT:
	 		
	 		ninja.stopleft();
	 		break;

	 	case KeyEvent.VK_RIGHT:
	 		ninja.stopright();
 			break;

		case KeyEvent.VK_UP:
	 		System.out.println("Stop jumping");
	 		break;
	}
}
public void keyTyped(KeyEvent e){
	
}
	public void winLevel(){
		//stop
		nextLevel();
		//resume
	}
	public void nextLevel() {
		room = room + 1;
		chooseLevel (room);
	}
	public void chooseLevel(int room){
		//picks a level based on room number and random number
		
	}
}
