package NinjaGame;
import java.awt.Image;

public class Shuriken {
	private int dmg, speed;
	private Image shuriken;
	public int getDmg() {
		return dmg;
	}
	public int getSpeed() {
		return speed;
	}
	public Image getShuriken() {
		return shuriken;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setShuriken(Image shuriken) {
		this.shuriken = shuriken;
	}
	
}
