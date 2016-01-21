package muzeyen.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Settings {
	private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
	private static BufferedImage titleText = null;
	private static BufferedImage backButton = null;

	public static String musicStatus;
	public static String soundStatus;	
	public static void preLoad(){
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			titleText = loader.loadImage("/settingsTitle.png");
			backButton = loader.loadImage("/backButton.png");


		}catch(IOException e){
			e.printStackTrace();	
		}
	}
	public static void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		
		Font fnt0 = new Font("arial", Font.BOLD, 40);
		Font fntSub = new Font("arial",Font.ITALIC ,25);
		Font fntBTF = new Font("arial",Font.ITALIC ,10);

		g.setFont(fnt0);
		g.setColor(Color.WHITE);	
		g.drawImage(titleText, 55, 3, null);

		g.setFont(fntBTF);
		g.drawString("Game © Born To Fail 2016 ", 520, 475);
		
		g.setFont(fntSub);
		update();
		g.drawString(musicStatus, 25,100);
		g.drawString(soundStatus, 25,150);

		g.drawImage(backButton, 30, 400, null);

	}
	public static void update(){
		if (Game.sounds == true){
		   soundStatus = "Sounds: On";
		}
		if (Game.sounds == false){
		   soundStatus = "Sounds: Off";
		}
		
		if (Game.music == true){
			musicStatus = "Music: On";
		}
		if (Game.music == false){
			musicStatus = "Music: Off";
		}
	}

}
