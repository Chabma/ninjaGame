package NinjaGame;

import java.util.Random;

public class Level {
private int room;
Random generator = new Random();
Door exit = new Door();
	public Level (Door door, int l){
	room = l;
	exit = door;
	}

public Level() {
		// TODO Auto-generated constructor stub
	}
public boolean onPlatform(){
 return false;
}
public void nextLevel(){
	room = room + 1;
	exit.setCenterX(generator.nextInt(650) + 50); 
}
public void update(){
	// TODO 
}
public void setRoom(int l){
	room = l;
}
public int getRoom(){
	return room;
}
public int getDoorCenterX(){
	return exit.getCenterX();
}
public int getDoorCenterY(){
	return exit.getCenterY();
}

}
