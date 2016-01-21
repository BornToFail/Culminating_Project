package muzeyen.main;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;

import javax.sound.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
public class Music {
	File menuMusic;
	AudioInputStream ais;
	static Clip clip;
	public Music(){

		try{
			menuMusic = new File("/thesongofmypeople.wav");
			ais = AudioSystem.getAudioInputStream(menuMusic);
			clip= AudioSystem.getClip();
			clip.open(ais);
		}
		catch(Exception e){
			System.out.println(e);
		}


		//	AudioClip menuMusic;
		//	AudioClip backgroundMusic;
		//	public void playMenuMusic(){
		//		menuMusic = getAudioClip(getDocumentBase(), "/thesongofmypeople.wav");
		//		menuMusic.play();
		//	}
	}

	static void playMenuMusic() {
		try{
			clip.start();

		}
		catch(Exception e){
			System.out.println(e);
		}

	}

}
