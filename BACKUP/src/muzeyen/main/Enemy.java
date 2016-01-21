package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends MovingObject {
	public static boolean isGoingRight = true;
	private static BufferedImage enemy;
	//static ArrayList<Enemy> spawner = new ArrayList<Enemy>();
	public static boolean aggressive;

	public Enemy (double x, double y, double xSpeed, double ySpeed, int right, int top) {
		super (x,y,xSpeed,ySpeed,right,top);
	}
	
	public static void setSprite(){
		SpriteSheet ss = new SpriteSheet(Game.getSpriteSheet());
		enemy = ss.grabImage(4, 1, 32, 32);
	}

	public void tick(){
		setX(getX() + getxSpeed());
		setY(getY() + getySpeed());
	}
	
	public void render(Graphics g) {
		g.drawImage(enemy, (int)getX(), (int)getY(), null);
	}

//	public static void testBorders(){
//		for(int i = 0; i < Game.passiveSpawner.size(); i++){
//			if(Game.passiveSpawner.get(i).getX() >= 480){
//				isGoingRight = false;
//				while (isGoingRight = false){
//					Game.passiveSpawner.get(i).setxSpeed(-2);
//				}
//			}
//			else{
//				Game.passiveSpawner.get(i).setxSpeed(2);
//			}
//
//			if(Game.passiveSpawner.get(i).getY() >= 300){
//				Game.passiveSpawner.remove(i);
//			}
//		}
//	}


	public static void bulletcollisionTest(){

		for (int i = 0; i<Game.passiveSpawner.size(); i++){
			for(int j = 0; j< Controller.projectiles.size(); j++){
				double distance = Math.sqrt(Math.pow(Controller.projectiles.get(j).getX()-Game.passiveSpawner.get(i).getX(),2) + Math.pow(Game.passiveSpawner.get(i).getY()-Controller.projectiles.get(j).getY(),2));
				if (distance < 8){
					Game.passiveSpawner.remove(i);
					Controller.projectiles.remove(j);
					System.out.print("Enemy hit");
					HUD.score ++;
				}
			}
		}
			
	}
	public void animateOneStep() {
	}

	@Override
	public void draw(Graphics g) {
	}
}