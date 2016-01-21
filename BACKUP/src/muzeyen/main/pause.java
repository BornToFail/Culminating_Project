package muzeyen.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class pause {
	private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
	private static BufferedImage pausedText = null;

	private static Rectangle resumeButton = new Rectangle(250,300, 150, 50);
	private static  Rectangle quitButton = new Rectangle(250 ,400, 150, 50);

	public static void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			pausedText = loader.loadImage("/pauseTextOverlay.png");

		}catch(IOException e){
			e.printStackTrace();	
		}
		
		Font fnt0 = new Font("arial", Font.BOLD, 100);
		Font fntSub = new Font("arial",Font.ITALIC ,25);
		Font fntBTF = new Font("arial",Font.ITALIC ,10);

		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawImage(pausedText, 225, 50, null);


		g.setFont(fntSub);
		g.drawString("Resume", resumeButton.x+25,resumeButton.y+33);
		g.drawString("Quit", quitButton.x+25,quitButton.y+33);
		g2d.draw(resumeButton);
		g2d.draw(quitButton);
		
		
	}
	
}


