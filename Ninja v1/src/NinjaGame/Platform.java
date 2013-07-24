package NinjaGame;

import java.awt.Rectangle;

public class Platform {
	
	private int x;
	private int y;
	private int length;
	private int height;
	public Rectangle rect;
	
	public Platform (int xp, int yp, int lengthp, int heightp){
		x = xp;
		y = yp;
		length = lengthp;
		height = heightp;
		rect = new Rectangle(x,y,length,height);
	}
public Platform (){
	rect = new Rectangle(0,300,300,20);
	}



public boolean checkUpperCollision(Rectangle r){
    	if (r.getY() < rect.getY()){
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
