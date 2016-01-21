package muzeyen.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class characterSelection {
private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
private static BufferedImage titleText = null;
private static BufferedImage selectionF = null;
private static BufferedImage selectionO = null;
private static BufferedImage selectionP = null;	
private static BufferedImage backButton = null;
public static String overlay ="";

public static void preLoad(){
	BufferedImageLoader loader = new BufferedImageLoader();
	try{
		titleText = loader.loadImage("/characterSelectText.png");
		selectionF = loader.loadImage("/selectionF.png");
		selectionO = loader.loadImage("/selectionO.png");
		selectionP = loader.loadImage("/selectionP.png");
		backButton = loader.loadImage("/backButton.png");

	}catch(IOException e){
		Game.State = Game.STATE.G_ERROR;
		e.printStackTrace();	
	}
}

public static void render(Graphics g) throws IOException{


	
	Font fnt0 = new Font("arial", Font.BOLD, 40);
	Font fntSub = new Font("arial",Font.ITALIC ,25);
	Font fntBTF = new Font("arial",Font.ITALIC ,10);

	g.setFont(fnt0);
	g.setColor(Color.WHITE);	
	g.drawImage(titleText, 55, 3, null);

	g.setFont(fntBTF);
	g.drawString("Game © Born To Fail 2016 ", 520, 475);
	g.drawString(overlay, 500, 400);
	g.setFont(fntSub);
	//g.drawString("Settings", settingsButton.x+25,settingsButton.y+33);
	//g.drawString("Quit", quitButton.x+25,quitButton.y+33);
	g.drawImage(selectionO, 10, 50, null);
	g.drawImage(selectionF, 225, 50, null);
	g.drawImage(selectionP, 440, 50, null);
	g.drawImage(backButton, 30, 400, null);
	
	

}
}

