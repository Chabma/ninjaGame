package NinjaGame;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.lang.Math.*;

public class Starter extends Applet implements Runnable , KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int room = 1;
	private boolean playerIsAlive;
	Ninja ninja = new Ninja();
	Level zone = new Level() ;
	private Image image, character, door;
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
			door = getImage(base, "data/door.png");
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
			if (Math.abs(ninja.getCenterX() - zone.getDoorCenterX()) < 5 &&
				Math.abs(ninja.getCenterY() - zone.getDoorCenterY() - 17) < 5) {
				zone.nextLevel();
			}
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
				g.drawImage(door, zone.getDoorCenterX() - 31, zone.getDoorCenterY() - 23, this);
				g.drawImage(character, ninja.getCenterX() - 31, ninja.getCenterY() - 23, this); 
				g.drawString(zone.getRoom() +"", 400,400);
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
}
	