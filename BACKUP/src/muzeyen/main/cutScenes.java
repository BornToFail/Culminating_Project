package muzeyen.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
//import java.awt.image.RescaleOp;
import java.io.IOException;

public class cutScenes {
	private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
	private static BufferedImage oTalkS = null;
	private static BufferedImage oDBox = null; //placeholder dialouge box
	private static BufferedImage phTalkS = null;
	private static BufferedImage phDBox = null;
	private static BufferedImage arrowDown = null;
	
	
	static int cutscene_F = 0;
	static Font fntL = new Font("arial", Font.BOLD, 15);

public static void render(Graphics g){
	Graphics2D g2d = (Graphics2D) g;

	BufferedImageLoader loader = new BufferedImageLoader();
//	RescaleOp rescaleOp = new RescaleOp(1.2f, 15, null);

	try{
		oDBox = loader.loadImage("/ottoDialougeBox.png");// Otto's  Dialogue box
		oTalkS = loader.loadImage("/ottoTalkSprite_1.png");// Otto portrayed at mid health
		phTalkS = loader.loadImage("/placeholderTalkSprite.png");// Otto portrayed at low health
		phDBox = loader.loadImage("/placeholderDialogueBox.png");// Placeholder Dialogue box
		arrowDown = loader.loadImage("/arrowDown.png");// Placeholder Dialogue box

	}catch(IOException e){
		e.printStackTrace();	
	}
	if (cutscene_F == 0){
		g.setFont(fntL);
		g.setColor(Color.WHITE);
		g.drawImage(oDBox, 125, 350, null);
		g.drawImage(oTalkS, 0, 270, null);
		g.drawString("What are you looking at?",150 ,400 );
	}
	else if (cutscene_F == 1){
		g.setFont(fntL);
		g.setColor(Color.WHITE);
		g.drawImage(phDBox, 125, 350, null);
//		rescaleOp.filter(oTalkS, oTalkS);
		g.drawImage(oTalkS, 0, 270, null);
		g.drawImage(phTalkS, 400, 280, null);
		g.drawString("What does it look like?",150 ,400 );
	}
}

}

