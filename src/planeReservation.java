
import java.util.Scanner;

/**
 * @author Ali Ghanem
 *
 */
public class planeReservation {
	static char[][] seats = { { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' },
			{ 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' }, { 'A', 'B', 'C', 'D' } };

	public static boolean isFull() {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j] != 'X') {
					return false;
				}
			}
		}
		return true;
	}

	public static void printSeats() {
		int row = 1;
		for (int i = 0; i < seats.length; i++) {
			System.out.print(row++ + " ");
			for (int k = 0; k < seats[i].length; k++) {
				System.out.printf(seats[i][k] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * @param character
	 * @return the corresponding index in the array
	 */
	public static int getIndex(char character) {
		switch (character) {
		case 'A':
			return 0;
		case 'B':
			return 1;
		case 'C':
			return 2;
		default:
			return 3;
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		while (!isFull()) {
			printSeats();
			System.out.println("Enter any key to to reserve a seat, or enter X to exit the program...");
			char check = Character.toUpperCase(scan.nextLine().charAt(0));
			if (check == 'X') {
				System.out.println("GoodBeye!!!");
				System.exit(0);
			}

			// get row from user:
			System.out.println("Please enter seat's row number...");
			int row = 0;
			boolean rowTaken = false;
			while (!rowTaken) {
				int checkRow = Character.getNumericValue(scan.nextLine().charAt(0));
				if (checkRow >= 1 && checkRow <= 7) {
					row = checkRow;
					rowTaken = true;
				} else {
					System.out.println("Wrong input, please enter a number between 1 and 7 !!");
				}
			}

			// get column from user:
			System.out.println("Please enter a character represents the seat you wish to reserve... ");
			char column = ' ';
			boolean columnTaken = false;
			while (!columnTaken) {
				char checkColumn = Character.toUpperCase(scan.nextLine().charAt(0));
				if (checkColumn >= 'A' && checkColumn <= 'D') {
					column = checkColumn;
					columnTaken = true;
				} else {
					System.out.println("Wrong input, please enter a seat between A and D !!");
				}
			}

			// check if seat is available, otherwise reserve it.
			if (seats[row - 1][getIndex(column)] == 'X') {
				System.out.println("Sorry, place is already taken, try to take another one.");
			} else {
				seats[row - 1][getIndex(column)] = 'X';
				System.out.println("Your seat " + row + column + " has been reserved successfully.");
			}
		}
		System.out.println("Plane is Full.");
		System.exit(0);

	}
}
