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
	
	private static double intensity;
	
	
	/*public Boss() {
			
	}
*/	
	public Boss (double x, double y, double xSpeed, double ySpeed, int right, int top) {
		super (x,y,xSpeed,ySpeed,right,top);
	}
	
	
	public static void GoBoss(){
		Difficulty();
		
	}
	
	
	
	public static void Difficulty(){
		/*The difficulty method is used to 
		 * determine the speeds of the boss
		 * Uses Intensity method to determine 
		 * the rate at which the speeds are
		 * multiplied.
		 */
		double level = (HUD.score)/1000; 
		for (int i=0; i<=100; i++){
			if (level==i){
				r = i*0.314;
				setXSpeed(xSpeed, r);
				setYSpeed(ySpeed, r);
			}
		}
	}
	
	
	
	public static void setSprite(){
		SpriteSheet ss = new SpriteSheet(Game.getSpriteSheet());
		boss = ss.grabImage(1, 4, 32, 32);
		//Boss(); //To start boss movement
		
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
	
	
	/*private void Shooting(double speed){
		//If boss shoots, player freezes for 2 seconds
		For shooting
		 * Loop that detects increasing angles of some
		 * kind and shoots bullets every x degrees.
		 * Bullets travel in straight lines.
		 
	}*/
	
	public void wallCollision(ArrayList<Enemy> Enemies){
		if (this.getX() >= 400 )
			setXSpeed(xSpeed, -1);
		if (this.getX() <= 0 )
			setXSpeed(xSpeed, -1);
		if (this.getY() <= 0){
			setYSpeed(ySpeed, -1);
		}
		
	}
	
	/*public static void bulletcollision(ArrayList <Enemy> Enemies , ArrayList <Bullet> Bullets){

		for (int i = 0; i<Game.passiveSpawner.size(); i++){
			for(int j = 0; j< Controller.projectiles.size(); j++){
				double distance = Math.sqrt(Math.pow(Bullets.get(j).getX()- Enemies.get(i).getX(),2) + Math.pow(Enemies.get(i).getY()-Bullets.get(j).getY(),2));
				if (distance < 8){
					Game.passiveSpawner.remove(i);
					Controller.projectiles.remove(j);
					System.out.print("Enemy hit");
					HUD.score ++;
				}
			}
		}
			
	}*/
	
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
