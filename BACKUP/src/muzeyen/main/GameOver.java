package muzeyen.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameOver {
	private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
	private static BufferedImage menuButton = null;
	private static BufferedImage replayButton = null;
	private static BufferedImage quitButton = null;
	private static BufferedImage gameoverText = null;
	private static BufferedImage background = null;
	private static BufferedImage highScoresBG = null;
	private static BufferedImage highScoresTitle= null;
	public static void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			menuButton = loader.loadImage("/menuButton.png");// The play button
			replayButton = loader.loadImage("/replayBtn.png");
			quitButton = loader.loadImage("/quitButton.png");
			gameoverText = loader.loadImage("/gameoverTitle.png");
			background = loader.loadImage("/background.png");
			highScoresBG = loader.loadImage("/highScoresBG.png");
			highScoresTitle = loader.loadImage("/highScoresTitle.png");


		}catch(IOException e){
			e.printStackTrace();	
			Game.State = Game.STATE.G_ERROR;
		}
		g.setColor(Color.WHITE);
		g.drawImage(background, 0, 0, null);
		g.drawString("Last Round's Score:" + HUD.score, 460, 145);
		g.drawString("Game © Born To Fail 2016 ", 520, 475);
		g.drawImage(gameoverText, 30, 30, null);
		g.drawImage(highScoresTitle, 75, 100, null);
		g.drawImage(highScoresBG, 40, 150, null);
		g.drawImage(menuButton, 460, 300, null);
		g.drawImage(replayButton, 460, 200, null);
		g.drawImage(quitButton, 460, 400, null);


		
	}
	
}
