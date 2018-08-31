import java.util.*;

/**
 * Seshasai Vaddadhi
 * CMPS12A 
 */
public class Craps {
	static int chips = 0;
	static int bet = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Seed: ");
		int seed = scan.nextInt();
		System.out.print("How many chips do you want? ");
		chips = scan.nextInt();
	
		scan.nextLine();
		while (chips > 0) {
			System.out.print("Enter bet: ");
			bet = scan.nextInt();
			//do while chips are less than bet
			while (chips < bet) {
				// checks if bet is more than available chips
				if (bet > chips) {
					System.out.println("Not an ok bet");
					System.out.print("Enter bet: ");
					bet = scan.nextInt();
				}
			}
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Press enter to roll dice ");
			scan1.nextLine();
			playCraps();
		}
	}

	/**
	 *   method to play the Craps game
	 *    this does not return any value;
	 */
	public static void playCraps(){	
		//roll dice and get the total
		int total = rollDice();
				
		if(total == 7 || total == 11){ //If 7 or 11 is rolled then the chips are added to the bet. 
			chips += bet;
			System.out.println("You won, you now have "+ chips);
		} else if (total == 2 || total == 3 || total == 12 ){
			chips -= bet;
			System.out.println("You lost, you now have "+ chips);
		} else {
			System.out.println("The point is "+ total);
			 int point = total;
			 //looping until the dice total is equal to point or 7
			 
			while(true) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Press enter to roll dice ");
				scanner.nextLine();
				int tot = rollDice();
				if(tot == point) {
					chips += bet;
					System.out.println("You won, you now have "+ chips);
					break;
				} else if(tot == 7) {
					chips -= bet;
					System.out.println("You lost, you now have "+ chips);
					break;
				}	
			}
		}
	}

	/**
	 * 
	 * @return
	 *    the total of the two dices;
	 */
	public static int rollDice() {
		Random rand = new Random();
		int dice1 = rand.nextInt(6) + 1;
		int dice2 = rand.nextInt(6) + 1;
		System.out.println("Roll is " + dice1 + "," + dice2);
		return (dice1 + dice2);
	}

}
