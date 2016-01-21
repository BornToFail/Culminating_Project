package muzeyen.main;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class HighScore {
	static ArrayList<Integer> savedScores = new ArrayList<Integer>();
	static ArrayList<String> savedNames = new ArrayList<String>();
	static int tempScore = 0;
	static String tempName = "";

	public static void loadScores(){
		int scoreNumber = 0;
		String topPlayer = "XXXXX";
		String secondPlayer = "XXXXX";
		String thirdPlayer = "XXXXX";
		String fourthPlayer = "XXXXX";
		String fifthPlayer = "XXXXX";

		try{
			BufferedReader reader = new BufferedReader(new FileReader("/highscore.txt"));
			String text = null;
			while ((text = reader.readLine())!= null){
				savedScores.add(Integer.parseInt(reader.readLine()));
				savedNames.add(reader.readLine());
			}


		}
		catch (IOException e){
			Game.State = Game.STATE.G_ERROR;
			e.printStackTrace();	
		}

		
	}
	public static void testScores(int currentScore, String currentName){
		for (int i = 0; i < savedScores.size();i++){
			if(currentScore > savedScores.get(i)){
				tempName = savedNames.get(i);
				tempScore = savedScores.get(i);
				savedScores.remove(i);
				savedNames.remove(i);
				savedScores.add(currentScore);
				savedNames.add(currentName);
				currentScore = tempScore;
				currentName = tempName;
			}
		}
		//augh why
	}
	public static void saveScores(){

	}
}
