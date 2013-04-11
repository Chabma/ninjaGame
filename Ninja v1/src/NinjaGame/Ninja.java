	package NinjaGame;

	public class Ninja {
	        //In Java, Class Variables should be private so that only its methods can change them.
		private int centerX = 100;
		private int centerY = 402;
		private boolean jumped = false;

		private int speedrightX = 0;
		private int speedleftX = 0;
		private int speedY = 1;

		public void update() {

			// Moves Character 
			centerX += speedrightX + speedleftX;
		
			// Updates Y Position

			if (centerY + speedY >= 382) {
				centerY = 382;
			}else{                       
	                     centerY += speedY;
	                }

			// Handles Jumping
			if (jumped == true) {
				speedY += 1;

				if (centerY + speedY >= 382) {
					centerY = 382;
					speedY = 0;
					jumped = false;
				}

			}

			// Prevents going beyond X coordinate of 0
			if (centerX + speedleftX + speedrightX <= 30) {
				centerX = 31;
			}
			// Prevents going beyond X coordinate of 800
			if (centerX + speedleftX + speedrightX >= 790) {
				centerX = 789;
			}
		}

		public void moveRight() {
			speedrightX = 6;
		}

		public void moveLeft() {
				speedleftX = -6;
		}

		public void stopleft() {
			speedleftX = 0;
		}

		public void stopright() {
			speedrightX = 0;
		}
		public void jump() {
			if (jumped == false) {
				speedY = -15;
				jumped = true;
			}
		}	
		public int getCenterX(){
			return centerX;
		}
		public int getCenterY(){
			return centerY;
		}

		public boolean isJumped() {
			return jumped;
		}

		public int getSpeedX() {
			return speedleftX + speedrightX;
		}
		public int getSpeedY() {
			return speedY;
		}

		public void setCenterX(int centerX) {
			this.centerX = centerX;
		}

		public void setCenterY(int centerY) {
			this.centerY = centerY;
		}

		public void setJumped(boolean jumped) {
			this.jumped = jumped;
		}


		public void setSpeedY(int speedY) {
			this.speedY = speedY;
		}				
	}

