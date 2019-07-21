import java.util.Random;
import java.util.Scanner;

public class SpaceInvaderTextBased2 {

	static int ROWS = 10, COLUMNS = 10;
	static Random random = new Random();
	static boolean ships[][] = new boolean[ROWS][COLUMNS];
	static int currentCol = random.nextInt(COLUMNS);
	static Scanner scanner = new Scanner(System.in);
	public static void shiftDown() {

 		
		for(int i = ROWS-4; i >= 0; i--) {

			for(int j=0; j<COLUMNS; j++) {


				ships[i + 1][j] = ships[i][j];

			}

		}


		for(int i=0; i<COLUMNS; i++) {

			ships[0][i] = false;

		}


		int shipIndex = random.nextInt(COLUMNS);

		if(shipIndex < COLUMNS) {

			ships[0][shipIndex] = true;

		}

	}

	public static void fireOnColumn(int col) {

		for(int i=0; i<ROWS; i++) {

			ships[i][col] = false;

		}

	}

	public static void printShips() {

		System.out.print("\n ");

		for(int j=-1; j<COLUMNS; j++) {

			System.out.print((j+1) + "  ");

		}

		System.out.println("\n---------------------------------");

		for(int i=0; i<ROWS; i++) {

			System.out.printf("%2s ", (i+1));

			for(int j=0; j<COLUMNS; j++) {

				if(ships[i][j]) {

					System.out.print(" * ");

				} else {

					System.out.print(" | ");

				}

			}

			System.out.println();

		}

		System.out.println("---------------------------------");

		System.out.print(" ");

		for(int j=0; j<COLUMNS; j++) {

			if(j == currentCol) {

				System.out.print("P1");

			}

			System.out.print(" ");

		}

		System.out.println();

	}

	public static String getChoice() {

		System.out.print("Enter your choice('f' to fire, 'm <Col no>' to move: ");

		return scanner.nextLine();

	}

	private static boolean gameOver() {

		boolean gameOver = false;


		for(int i=0; i<COLUMNS; i++) {

			if(ships[ROWS-1][i]) {

				gameOver = true;

				break;

			}

		}

		return gameOver;

	}

	public static void main(String[] args) {

		shiftDown();

		printShips();

		while(true) {

			String choice = getChoice();

			if(choice.equalsIgnoreCase("f")) {

				fireOnColumn(currentCol);

				shiftDown();

				printShips();

			} else if(choice.startsWith("m")) {

				String tokens[] = choice.split(" ");

				int col = Integer.parseInt(tokens[1]) - 1;

				if((col < 0) || (col >= COLUMNS)) {

					System.out.println("invalid column index. Try again.");

				} else {

					if(gameOver()) {

						System.out.println("Game Over.");

						break;

					}

					currentCol = col;

					shiftDown();

					printShips();

				}

			} else {

				System.out.println("Invalid choice. Try again.");

			}

		}

		System.out.println("Better Luck next time!");

	}

	}