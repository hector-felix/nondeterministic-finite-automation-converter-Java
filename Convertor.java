import java.util.Arrays;
import java.util.Scanner;

public class Convertor {

	public static void main(String[] args) {
		int[] finalState;		
		String[] alphabet = {"Epsilon", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
		                     "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number of states");
		int states = sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter the number of symbols in the alphabet");
		int symbols = sc.nextInt() + 1;
		sc.nextLine();
//		int total = (int) Math.pow(states, symbols);
		int total = states * symbols;
		String[][] function = new String[states][symbols];
		System.out.println("Please enter the start state");
		int startStat = sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter all final states on one line in format {1,2,3,.,n'}");
		String finalStates = sc.nextLine();
		String test;
		int test1 = 1;
//		System.out.println("enter two numbers");
//		test = scanner.nextLine();
//		test = test.substring(1, test.length() - 1);
//		if (test.length() == 1) {
//			System.out.println("we good, no split");
//		} else {
//			String[] parts = test.split(",");
//			String entry1 = parts[0];
//			String entry2 = parts[1];
//			System.out.println(entry1);
//			System.out.println(entry2);
//		}
//		System.out.println(test);
//		System.out.println(test1);
//		
		int counter = 1;
		for(int i = 0; i < total; i++) {
			if(i == 0) {
				System.out.println("Delta(1,a) = ");
				function[0][1] = scanner.nextLine();
			}
			else {
				if(i % symbols == 0) {
					counter++;
				}
				if(counter == states) {
					System.out.println("Delta(" + counter + "," + alphabet[(i+1)%(symbols)] + ") = ");
					function[counter-1][(i+1)%(symbols)] = scanner.nextLine();
					continue;
				}
				
				System.out.println("Delta(" + (counter%states) + "," + alphabet[(i+1)%(symbols)] + ") = ");
				function[(counter%states)-1][(i+1)%(symbols)] = scanner.nextLine();
				
			}
		}
		int total1 = (int) Math.pow(2, states);
		for(int i = 1; i < symbols;i++) {
			System.out.println("Delta'({}," + alphabet[i] + ") = empty");
		}
		int counter1 = 0;
			for(int i = 0; i < states; i++) {
				for(int j = 1;j<symbols;j++) {
				if(i % symbols == 0) {
					counter1++;
				}
				System.out.println("Delta'({" + (i+1) + "}," + alphabet[j] + ") = {" + function[i][j] + "}");
				}
			}
		}
	

	}


