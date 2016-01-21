package muzeyen.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;	
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ErrorScreen {
		private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB); //buffers window
		private static BufferedImage background = null;
		public static String errorMessage;
		
		public static  Rectangle backButton = new Rectangle(30,400, 200, 50);
		
		public static void preLoad(String errorText){
			BufferedImageLoader loader = new BufferedImageLoader();
			try{
				background = loader.loadImage("/background.png");

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
			g.drawString("Game Crashed\n If errors persist, please contact Born To Fail.", 50, 50);
			g.setFont(fntBTF);
			g.drawString("Game © Born To Fail 2016 ", 520, 475);
			g.drawImage(background, 0, 0, null);
			g.setFont(fntSub);

			


			//g.drawString("Back", backButton.x+25,backButton.y+33);
			//g.drawString("Settings", settingsButton.x+25,settingsButton.y+33);
			//g.drawString("Quit", quitButton.x+25,quitButton.y+33);
		}


	}


