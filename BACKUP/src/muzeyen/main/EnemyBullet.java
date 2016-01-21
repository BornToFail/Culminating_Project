package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends MovingObject {
	static ArrayList<Bullet> enemyBullets = new ArrayList<Bullet>();
	public static boolean cooldown = false;
	private static BufferedImage enemyBullet;
	//static ArrayList<Enemy> spawner = new ArrayList<Enemy>();
	public static boolean aggressive;

	public EnemyBullet (double x, double y, double xSpeed, double ySpeed, int right, int top) {
		super (x,y,xSpeed,ySpeed,right,top);
	}
	
	public static void setSprite(){
		SpriteSheet ss = new SpriteSheet(Game.getSpriteSheet());
		enemyBullet = ss.grabImage(6, 1, 32, 32);
	}

	public void tick(){
		setY(getY() + getySpeed());
	}
	
	public void render(Graphics g) {
		g.drawImage(enemyBullet, (int)getX(), (int)getY(), null);
	}

	public static void testBorders(){
		
	}

	public static void playercollisionTest(){

		if (cooldown == false){
			for (int i = 0; i<enemyBullets.size() && cooldown == false; i++){
				double distance = Math.sqrt((Game.p.getX()-enemyBullets.get(i).getX())*(Game.p.getX()-enemyBullets.get(i).getX())-((Game.p.getY()-enemyBullets.get(i).getY()*(Game.p.getY()-enemyBullets.get(i).getY()))));
				if (distance < 16){
					//timeOfDeath = System.currentTimeMillis();
					Player.lives --;
					Player.blinking= true;
					enemyBullets.remove(i);
					cooldown = true;
					}
				}
			}
//		else{
//			
//			if (System.currentTimeMillis()- timeOfDeath > 3000){
//				Player.blinking = false;
//				cooldown = false;
//				System.out.println( "cooldown is up");
//			}
//		}

	}

	public void animateOneStep() {
	}

	@Override
	public void draw(Graphics g) {
	}
}