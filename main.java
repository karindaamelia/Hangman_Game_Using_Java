package Hangman;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		Scanner userInput = new Scanner(System.in);
		String choose;
		boolean start = true;
		
		System.out.println("====================================");
		System.out.println("||     WELCOME TO THE HANGMAN     ||");
		System.out.println("====================================");
		
		System.out.println("\nAre you ready to start this game ??? (Y/N)");
		System.out.println("\t(Y) --> YES");
		System.out.println("\t(N) --> NO");
		
		while(start == true) {
			System.out.print("\nEnter your Choise : ");
			choose = userInput.next();
			System.out.println();
			
			if(choose.equalsIgnoreCase("Y")) {
				System.out.println();
				HangmanGame hangmanGame = new HangmanGame();
		        hangmanGame.play();
				start = false;
			} else if(choose.equalsIgnoreCase("N")) {
				System.out.println("\n===== THANK YOU ^_^ =====");
				start = false;
				break;
			} else {
				System.out.println("\nThe option is not available");
				System.out.println("Please enter your choose again !");
			}
		}
	}
}

class HangmanGame {
	private Player player;
	private Words secretWord;
	private LetterBox letterBox;
	private int wrongGuessCount = 7;
	
	public HangmanGame() {
		player = new Player();
		player.askName();
		System.out.println();
		secretWord = new Words();
		letterBox = new LetterBox();
	}
	
	private void printDisplay() {
		letterBox.print();
		System.out.print("Hidden Word : ");
		secretWord.print();
		System.out.print("Lives : " + wrongGuessCount + "\n\n");
		
		switch(wrongGuessCount) {
		case 7:
			System.out.println("|---------------------");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("*****************************");
			break;
		case 6:
			System.out.println("|---------------------");
			System.out.println("|       O");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("************************************");
			break;
		case 5:
			System.out.println("|---------------------");
			System.out.println("|       O");
			System.out.println("|       |");
			System.out.println("|       |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("************************************");
			break;
		case 4:
			System.out.println("|---------------------");
			System.out.println("|       O");
			System.out.println("|    ___|");
			System.out.println("|       |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("************************************");
			break;
		case 3:
			System.out.println("|---------------------");
			System.out.println("|       O");
			System.out.println("|    ___|___");
			System.out.println("|       |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("************************************");
			break;
		case 2:
			System.out.println("|---------------------");
			System.out.println("|       O");
			System.out.println("|    ___|___");
			System.out.println("|       |");
			System.out.println("|      /");
			System.out.println("|     / ");
			System.out.println("|    /");
			System.out.println("|");
			System.out.println("|");
			System.out.println("************************************");
			break;
		case 1:
			System.out.println("|---------------------");
			System.out.println("|       O");
			System.out.println("|    ___|___");
			System.out.println("|       |");
			System.out.println("|      /|");
			System.out.println("|     / |");
			System.out.println("|    /  |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("************************************");
			break;
		}
		System.out.print("Please enter your guess : ");
	}
	
	public void play() {
		boolean status = true;
		
		while(true) {
			status = true;
			printDisplay();
			char ch = player.guess();
			
			if(letterBox.contains(ch)) {
				System.out.println("Try again, You've already used the letter " + ch + "\n");
				status = false;
			}
			if(status) {
				if(secretWord.guess(ch)) {
					System.out.println("===>> Great, You have found the letter " + ch + "\n");
				} else {
					if(wrongGuessCount != 0) {
						System.out.println( "===>> Ohh sorry, You Wrong. \n\nPlease try again : " + ch + "\n");
						wrongGuessCount--;
					} else {
						System.out.println();
					}
				}
				
				if(wrongGuessCount < 1) {
                    lose();
				}
				
                if(secretWord.found()) {
                    win();
                }
			}
		}
	}
	
	public void win() {
		System.out.println("\n------- Congratulations " + player +  ", YOU WIN!!!!!-------");
		System.out.println("\n======= GAME OFF =======");
        System.exit(0);
	}
	
	public void lose() {
		System.out.println( "Sorry " + player + ", you lose. Better luck next time!" );
		System.out.println("\n======= GAME OFF =======");
		System.exit(0);
	}
}

class Words {
	
	private String a;
	private StringBuffer b;
	private int found = 0;
	{
		String Words[] = new String[50];
		Words[0] = "EQUIPMENT";
		Words[1] = "STUDENT";
		Words[2] = "ENVIRONMENT";
		Words[3] = "TEMPERATURE";
		Words[4] = "INFORMATION";
		Words[5] = "TELEPHONE";
		Words[6] = "GOVERNMENT";
		Words[7] = "HEALTH";
		Words[8] = "COMPUTER";
		Words[9] = "LITERATURE";
		Words[10] = "KNOWLEDGE";
		Words[11] = "ABILITY";
		Words[12] = "NATURE";
		Words[13] = "ACTIVITY";
		Words[14] = "QUALITY";
		Words[15] = "LANGUAGE";
		Words[16] = "SECURITY";
		Words[17] = "THOUGHT";
		Words[18] = "DIRECTION";
		Words[19] = "TECHNOLOGY";
		Words[20] = "FREEDOM";
		Words[21] = "UNIVERSITY";
		Words[22] = "DEPARTMENT";
		Words[23] = "GROWTH";
		Words[24] = "ADMIRE";
		Words[25] = "APOLOGIZE";
		Words[26] = "APPROACH";
		Words[27] = "CELEBRATE";
		Words[28] = "CONTINUE";
		Words[29] = "DETERMINE";
		Words[30] = "ENCOURAGE";
		Words[31] = "ADDITIONAL";
		Words[32] = "AVAILABLE";
		Words[33] = "COMPETITIVE";
		Words[34] = "CONFIDENT";
		Words[35] = "DIFFICULT";
		Words[36] = "EXPENSIVE";
		Words[37] = "FRIENDLY";
		Words[38] = "IMPORTANT";
		Words[39] = "IMPOSSIBLE";
		Words[39] = "COMPARE";
		Words[40] = "EXPLAIN";
		Words[41] = "PREVENT";
		Words[42] = "REMEMBER";
		Words[43] = "UNDERSTAND";
		Words[44] = "NERVOUS";
		Words[45] = "TELEVISION";
		Words[46] = "CHILD";
		Words[47] = "WATERMELON";
		Words[48] = "MUSHROOM";
		Words[49] = "SAUSAGE";
		
		Random random = new Random();
		int randomWord = random.nextInt(49);
		String[] displayLetters = new String[Words[randomWord].length()];
		a = Words[randomWord];
		b = new StringBuffer(a.length());
		
		for(int i = 0; i < displayLetters.length; i++) {
			displayLetters[i] = "*";
			b.append('*');
		}
	}
	
	public boolean found() {
		System.out.println("\nLetters found : " + found + "/" + a.length());
		return(found == a.length());
	}
	
	public boolean guess(char character) {
		int index = a.indexOf(character);
		
		if(index == -1) {
			return false;
		} else {
			found = found + findOccurances(character);
			return true;
		}
	}
	
	private int findOccurances(char character) {
		int idx = a.indexOf(character);
		b.setCharAt(idx, a.charAt(idx));
		
		int counter = 1;
		while(idx != -1) {
			int index = a.indexOf(character, idx + 1);
			idx = index;
			
			if(idx != -1) {
				counter++;
				b.setCharAt(idx, a.charAt(idx));
			}
		}
		return counter;
	}
	
	public void print() {
		System.out.println(b);
	}	
}

class Player {
	private String name = " ";
	public void askName() {
		System.out.println("------------------------------");
		System.out.println("|   Welcome To The Hangman   |");
		System.out.println("------------------------------");
		System.out.print("\nHi, Before starting this game, Please enter your name : ");
		name = input();
		System.out.println("===>> Hi " + name + ", Enjoy this game ^_^");
		System.out.println("\n\n======= GAME ON =======\n");
	}
	
	public char guess() {
		return input().charAt(0);
	}
	
	private String input() {
		String userInput = " ";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			userInput = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInput;
	}
	
	public String toString() {
		return name;
	}
}

class LetterBox {
	private char[] letterBox = new char[50];
	private int counter = 0;
	
	public boolean contains(char character) {
        for(int i = 0; i < counter; i++) {
            if(letterBox[i] == character) {
                return true;
            }
        }
        letterBox[counter] = character;
        counter++;
        return false;
    }
	
	public void print()  {
        System.out.print("Letter Box : ");
        for(int i = 0; i < counter; i++) {
            System.out.print(letterBox[i]);
        }
        System.out.println(" ");
    }
}









