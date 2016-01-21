package muzeyen.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HUD {
	private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
	private static BufferedImage ottoFH = null;
	private static BufferedImage ottoMH = null;
	private static BufferedImage ottoLH = null;
	private static BufferedImage fennFH = null;
	private static BufferedImage fennMH = null;
	private static BufferedImage fennLH = null;

	private static BufferedImage blobFH = null;
	public static int score = 0;
	public static String playerName;
	public static  Rectangle hudFrame = new Rectangle(160,481, 500, 0);
	
	public static void preload(){
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			ottoFH = loader.loadImage("/ottoFullHealth.png");// Otto portrayed at full health
			ottoMH = loader.loadImage("/ottoMidHealth.png");// Otto portrayed at mid health
			ottoLH = loader.loadImage("/ottoLowHealth.png");// Otto portrayed at low health
			
			fennFH = loader.loadImage("/fennFullHealth.png");// Fennel portrayed at low health
			fennMH = loader.loadImage("/fennMidHealth.png");// Fennel portrayed at low health
			fennLH = loader.loadImage("/fennLowHealth.png");// Fennel portrayed at low health

			//blobFH = loader.loadImage("/blobFullHealth.png");// Blob portrayed at full health

		}catch(IOException e){
			e.printStackTrace();	
			Game.State = Game.STATE.G_ERROR;

		}
	}

	
	public static void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		
		Font Konami = new Font("Comic Sans MS", Font.PLAIN, 15);
		Font fntL = new Font("arial", Font.BOLD, 15);
//		Font fntSub = new Font("arial",Font.ITALIC ,25);
		Font fntBTF = new Font("arial",Font.ITALIC ,10);
//

		if(Game.konami == true){
			
			if (Game.hudTimer/100 % 100 == 0){
				g.setFont(Konami);
				g.setColor(Color.GREEN);
				g.drawString("FOLLOW ISSA ON DEVIANTART FOR QUALITY CONTENT ", 50, 200);
			}
			else{
				g.setColor(Color.WHITE);
			}
		}
		String livesLeft = "";
		
		if (Player.lives >= 3){
			if (Game.konami == true){
				g.drawImage(blobFH, 501, 0, null);
				}
				
			else{
			livesLeft = "* * *";
			if (Player.selectedCharacter == 1){
			g.drawImage(ottoFH, 501, 0, null);
			}
			else if (Player.selectedCharacter == 2){
				g.drawImage(fennFH, 501, 0, null);
			}
			}
			}
		else if (Player.lives == 2){
			livesLeft ="* *";
			if (Game.konami == true){
				
			}
			else if(Player.selectedCharacter == 1){
			g.drawImage(ottoMH, 501, 0, null);
			}			
			else if(Player.selectedCharacter == 2){
				g.drawImage(fennMH, 501, 0, null);
			}
	
		}else if (Player.lives == 1){
			livesLeft ="*";
			if(Player.selectedCharacter == 1){
			g.drawImage(ottoLH, 501, 0, null);
			}			
			else if(Player.selectedCharacter == 2){
				g.drawImage(fennLH, 501, 0, null);
			}
		}
		else{// (Player.lives <= 1)
			//check if it's in highscores
			//if it is, prompt them to add their name to save score
			//if not gameover screen
			HighScore.testScores(score, playerName);
			Game.State = Game.STATE.GAMEOVER;

		}
    	g.setFont(fntL);
		g.setColor(Color.WHITE);
		g.drawString("Lives "+ livesLeft, 510, 175);
		g.drawString("Score "+ score, 510, 225);
		g.drawString("Time "+ Game.hudTimer/100, 510, 275);
		g.drawString("Bombs "+ Player.bombs, 510, 325);
    	g.setFont(fntBTF);
    	int fps = Game.FPS;
	    g.drawString("FPS " + Integer.toString(fps), 540, 425);
	    g.drawString("Game © Born To Fail 2016 ", 540, 475);

//		g.setFont(fntSub);
		//g.drawString("Play", playButton.x+25,playButton.y+33);
		//g.drawString("Settings", settingsButton.x+25,settingsButton.y+33);
		//g.drawString("Quit", quitButton.x+25,quitButton.y+33);
		g2d.draw(hudFrame);
		
		
	}
}

