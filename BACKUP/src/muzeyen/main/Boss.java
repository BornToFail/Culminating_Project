package muzeyen.main;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;


/**
 * 
 */

/**
 * @author 342643103
 *
 */
//Start a counter when the boss level starts.
/*Timer T=new Timer();
T.scheduleAtFixedRate(new TimerTask() {         
                @Override
                public void run() {
                    runOnUiThread(new Runnable()
                    {

                        public void run()
                        {
                            countdown.setText(""+count);
                            count++;                
                        }
                    });
                }
            }, 1000, 1000);
*/

//T.cancel();

public class Boss implements Runnable {
	/**
	 * 
	 */
	private double X;
	private double Y;
	
	private double XSpeed;
	private double YSpeed;
	
	private int left;
	private int right;
	private int top;
	private int bottom;
	
	private boolean move;
	
	private BufferedImage boss;
	
	
	public Boss(double X, double Y, Game game) {
		this.X=X;
		this.Y=Y;
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		boss=ss.grabImage(5, 1, 32, 32);
	}
	
	public double getX(){
		return X;
	}
	public double getY(){
		return Y;
	}
	public void setX(double X){
		this.X = X;
	}
	public void setY(double Y){
		this.Y = Y;
	}
	
	public void setXSpeed(double XSpeed, double rate){
		this.XSpeed = XSpeed*rate;
	}
	public void setVelY(double YSpeed, double rate){
		this.YSpeed = YSpeed*rate;
	}
	
	
	private void Shooting(double speed){
		//If boss shoots, player freezes for 2 seconds
		/*For shooting
		 * Loop that detects increasing angles of some
		 * kind and shoots bullets every x degrees.
		 * Bullets travel in straight lines.
		 */
	}
	
	public Boss(double x, double y, int left, int right, int top,
			int bottom) {
		this.XSpeed = 0;
		this.YSpeed = 0;
		this.X = x;
		this.Y = y;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
		startThread();
	}
	
	public void startThread() {
		move = true;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void stopThread() {
		move = false;
	}
	
	public void run() {
		while (move) {
			X += XSpeed;
			Y += YSpeed;
			if (X >= right | X <= left){
				//XSpeed *= -1;
				X = left;
			}
			if (X >= left | X <= right){
				X = right;
			}
			if (Y >= bottom | Y <= top){
				//YSpeed *= -1;
				Y = top;
			}
			if (Y >= top | Y <= bottom){
				Y = bottom;
			}			
		}
	}
	
	

	

		

}
























































































































































