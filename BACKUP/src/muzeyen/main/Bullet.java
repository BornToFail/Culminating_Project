package muzeyen.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet {
	
	private double x;
	private double y;
	
	BufferedImage image;
	
	public Bullet(double x, double y, Game game){
		this.x = x;
		this.y = y;	
		
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		SpriteSheet ssk = new SpriteSheet(game.getSpriteSheetK());
		if (Game.konami == false){
		image = ss.grabImage(5, Player.selectedCharacter, 32, 32);
		}
		else if (Game.konami == true){
			image = ssk.grabImage(2, 1, 32, 32);
		}
	}
	
	public void tick(){
		y-=10;
	}
	public void render(Graphics g){
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	public double getY(){
		return y;
	}
	
	public double getX(){
		return x;
	}

}
