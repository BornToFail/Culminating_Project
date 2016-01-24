package muzeyen.main;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import muzeyen.main.Game.STATE;


/**
 * 
 */

/**
 * @author 342643103
 *
 */


public class Boss /*implements Runnable,*/ extends MovingObject {
	/**
	 * 
	 */
	private double x;
	private double y;
	private static double r;
	
	private static double xSpeed;
	private static double ySpeed;
	
	private int left;
	private int right;
	private int top;
	private int bottom;
	
	private boolean move;
	
	
	private static BufferedImage boss;
	
	public static boolean seeBoss = false;
	public static boolean shooting = false;
	
	/*public Boss() {
			
	}
*/	
	public Boss (double x, double y, double xSpeed, double ySpeed, int right, int top) {
		super (x,y,xSpeed,ySpeed,right,top);
	}
	
	
	public static void GoBoss(){
		Difficulty();
		setXSpeed(1, 0.5);
		setYSpeed(1, 0.5);
		setSprite(seeBoss);
		/*while (Game.State == STATE.GAME){
			FireAway(Game.hudTimer);
		}*/
		
	}
	
	
	
	public static void Difficulty(){
		/*The difficulty method is used to 
		 * determine the speeds of the boss
		 * Uses Intensity method to determine 
		 * the rate at which the speeds are
		 * multiplied.
		 */
		double level = (HUD.score)/1000; 
		for (int i=1; i<=100; i++){
			if (level==i){
				r = (i*(0.624));
				setXSpeed(1, r);
				setYSpeed(1, r);
			}
		}
	}
			
	public static void setSprite(boolean sB){
		SpriteSheet ss = new SpriteSheet(Game.getSpriteSheet());
		if (sB = false){
			boss = ss.grabImage(10, 10, 32, 32);
		}
		else if (sB = true){
			boss = ss.grabImage(1, 4, 32, 32);
		}
		
		
	}
	
	public void tick(){
		setX(getX() + getXSpeed());
		setY(getY() + getYSpeed());
	}
	
	public void render(Graphics g) {
		g.drawImage(boss,200, 200, null);
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public static double getXSpeed(){
		return xSpeed;
	}
	
	public static double getYSpeed(){
		return ySpeed;
	}
	
	public static void setXSpeed(double xSpeed, double rate){
		xSpeed = xSpeed*rate;
	}
	
	public static void setYSpeed(double ySpeed, double rate){
		ySpeed = ySpeed*rate;
	}
	
	
	private static void FireAway(){
		
		/*if (shooting = true){
			Player.setVelX((Player.velX)*0.2);
			Player.setVelY((Player.velY)*0.2);			
		}*/
		
		
	}
	
	public void BossHit(ArrayList <Bullet> Bullets){
		for(int j = 0; j< Controller.projectiles.size(); j++){
			double distance = Math.sqrt(Math.pow(Bullets.get(j).getX()- this.getX(),2) + Math.pow(this.getY()-Bullets.get(j).getY(),2));
			if (distance < 8){
				//Game.passiveSpawner.remove(i);
				Controller.projectiles.remove(j);
				System.out.print("Boss hit");
				HUD.score += 10;
			}
		}
		FireAway();
	}
	
	public void wallCollision(){
		if (this.getX() >= 400 )
			setXSpeed(xSpeed, -1);
		if (this.getX() <= 0 )
			setXSpeed(xSpeed, -1);
		if (this.getY() <= 0){
			setYSpeed(ySpeed, -1);
		}
		
	}
	
		
	public void run() {
		while (move) {
			x += xSpeed;
			y += ySpeed;
			if (x >= right | x <= left){
				//XSpeed *= -1;
				x = left;
			}
			if (x >= left | x <= right){
				x = right;
			}
			if (y >= bottom | y <= top){
				//YSpeed *= -1;
				y = top;
			}
			if (y >= top | y <= bottom){
				y = bottom;
			}			
		}
	}

	@Override
	public void animateOneStep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}

//Boss Behavior Game Class Line 155 & 191
