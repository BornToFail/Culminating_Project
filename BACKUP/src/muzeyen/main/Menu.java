package muzeyen.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu {
private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
private static BufferedImage playButton = null;
private static BufferedImage settingsButton = null;
private static BufferedImage quitButton = null;

public void render(Graphics g){
	Graphics2D g2d = (Graphics2D) g;
	BufferedImageLoader loader = new BufferedImageLoader();
	try{
		playButton = loader.loadImage("/playButton.png");// The play button
		settingsButton = loader.loadImage("/settingsButton.png");
		quitButton = loader.loadImage("/quitButton.png");
	}catch(IOException e){
		Game.State = Game.STATE.G_ERROR;
		e.printStackTrace();	
	}
	
	Font fnt0 = new Font("arial", Font.BOLD, 100);
	Font fntSub = new Font("arial",Font.ITALIC ,25);
	Font fntBTF = new Font("arial",Font.ITALIC ,10);

	g.setFont(fnt0);
	g.setColor(Color.WHITE);
	g.drawString("TEST", 375, 100);
	g.setFont(fntSub);
	g.drawString(">>Main Menu", 400, 150);
	g.setFont(fntBTF);
	g.drawString("Game © Born To Fail 2016 ", 520, 475);
	g.drawImage(playButton, 460, 200, null);
	if (Game.konami == false){
	g.drawImage(settingsButton, 460, 300, null);
	g.drawImage(quitButton, 460, 400, null);
	}

	
}
}
