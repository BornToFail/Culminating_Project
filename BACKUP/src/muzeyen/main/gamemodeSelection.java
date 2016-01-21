package muzeyen.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;	
import java.awt.image.BufferedImage;
import java.io.IOException;
import muzeyen.main.Game;

public class gamemodeSelection {

	private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
	private static BufferedImage titleText = null;
	private static BufferedImage survivalTitle = null;
	private static BufferedImage storyModeTitle = null;
	private static BufferedImage difficultyMedSM = null;
	private static BufferedImage difficultyHardSM = null;
	private static BufferedImage difficultyInsaneSM = null;
	private static BufferedImage difficultyMedS = null;
	private static BufferedImage difficultyHardS = null;
	private static BufferedImage difficultyInsaneS = null;
	private static BufferedImage backButton = null;





	public static void render(Graphics g) throws IOException{

		Graphics2D g2d = (Graphics2D) g;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			titleText = loader.loadImage("/gamemodeTitle.png");
			storyModeTitle = loader.loadImage("/storyModeTitle.png");
			survivalTitle = loader.loadImage("/survivalTitle.png");
			difficultyMedS = loader.loadImage("/difficultyMed.png");
			difficultyHardS = loader.loadImage("/difficultyHard.png");
			difficultyInsaneS = loader.loadImage("/difficultyInsane.png");
			difficultyMedSM = loader.loadImage("/difficultyMed.png");
			difficultyHardSM = loader.loadImage("/difficultyHard.png");
			difficultyInsaneSM = loader.loadImage("/difficultyInsane.png");
			backButton = loader.loadImage("/backButton.png");

		}catch(IOException e){
			Game.State = Game.STATE.G_ERROR;
			e.printStackTrace();	
		}

		
		Font fnt0 = new Font("arial", Font.BOLD, 40);
		Font fntSub = new Font("arial",Font.ITALIC ,25);
		Font fntBTF = new Font("arial",Font.ITALIC ,10);

		g.setFont(fnt0);
		g.setColor(Color.WHITE);	
		g.drawImage(titleText, 150, 3, null);
		g.drawImage(storyModeTitle, 100, 50, null);
		g.drawImage(survivalTitle, 400, 50, null);
		g.drawImage(difficultyMedS, 400, 125, null);
		g.drawImage(difficultyHardS, 400, 225, null);
		g.drawImage(difficultyInsaneS, 400, 325, null);
		g.drawImage(difficultyMedSM, 100, 125, null);
		g.drawImage(difficultyHardSM, 100, 225, null);
		g.drawImage(difficultyInsaneSM, 100, 325, null);
		g.drawImage(backButton, 30, 400, null);

		g.setFont(fntBTF);
		g.drawString("Game © Born To Fail 2016 ", 520, 475);
		
		//g.drawString("Settings", settingsButton.x+25,settingsButton.y+33);
		//g.drawString("Quit", quitButton.x+25,quitButton.y+33);

	}
}


