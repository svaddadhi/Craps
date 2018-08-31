import java.util.Random;

/**
 * 
 * @author Seshasai Vaddadhi
 *   This program calculates the win probablity of craps with a given number of trials. 
 */
public class CrapsProbability {
	public static void main(String[] args){
		int numTrials = Integer.parseInt(args[0]);
		double wins = 0;
		double losses = 0;
		
		Random rand = new Random();
	
		for(int i = 0; i < numTrials; i++ ){
			int dice1 = rand.nextInt(6) + 1;
			int dice2 = rand.nextInt(6) + 1;
			int total = dice1 + dice2;
			
			if( total == 7 || total == 11){
				wins = wins + 1;
			}
			else if(total == 2 || total == 3 || total == 12){
				losses = losses +1;
			}
			else{
				int point = total;
				while(true){
					dice1 = rand.nextInt(6) + 1;
					dice2 = rand.nextInt(6) + 1;
					if(point == (dice1 + dice2)){
						wins = wins +1;
						break;
					}
					else if((dice1 + dice2) == 7){
						losses = losses + 1;
						break;
					}
				}
			}
		}
		if (wins > 0) {
			System.out.println("Prob of Winning "+(wins / numTrials));
		}
	}
}
