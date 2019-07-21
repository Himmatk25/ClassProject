import java.util.Random;
import java.util.Scanner;

public class TextBased {
	static int ROWS = 10, COLUMNS = 6;

	static Random random = new Random();

	static boolean alienShips[][] = new boolean[ROWS][COLUMNS];

	static int currentColumn = random.nextInt(COLUMNS);

	static Scanner scanner = new Scanner(System.in);

	public static void shiftDown() {

	for(int i=ROWS-2; i>=0; i--) {

	for(int j=0; j<COLUMNS; j++) {

	alienShips[i + 1][j] = alienShips[i][j];
 
	}

	}

	for(int i=0; i<COLUMNS; i++) {

	alienShips[0][i] = false;

	}

	int shipIndex = random.nextInt(COLUMNS);

	if(shipIndex < COLUMNS) {

	alienShips[0][shipIndex] = true;

	}

	}

	public static void fireOnCol(int col) {

	for(int i=0; i<ROWS; i++) {

	alienShips[i][col] = false;

	}

	}

	public static void printShips() {

	System.out.print("\n ");

	for(int j=0; j<COLUMNS; j++) {

	System.out.print((j+1) + " ");

	}

	System.out.println("\n=============================");

	for(int i=0; i<ROWS; i++) {

	System.out.printf("%2s |", (i+1));

	for(int j=0; j<COLUMNS; j++) {

	if(alienShips[i][j]) {

	System.out.print(" X |");

	} else {

	System.out.print(" |");

	}

	}

	System.out.println();

	}

	System.out.println("=============================");

	System.out.print(" ");

	for(int j=0; j<COLUMNS; j++) {

	if(j == currentColumn) {

	System.out.print("Pl ");

	}

	System.out.print(" ");

	}

	System.out.println();

	}
	

}



