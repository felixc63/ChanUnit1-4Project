import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to TicTacToe!");

        boolean isIntGreaterThanOne = true;
        int repeat = 0;
        while (isIntGreaterThanOne) {
            System.out.print("How many times do you want the game to repeat? ");
            repeat = scan.nextInt();
            if (repeat <= 0) {
                System.out.println("Please enter a valid integer greater than 0.");
                System.out.println("Try again.");
                System.out.println();
            }else{
                isIntGreaterThanOne = false;
            }
        }

        System.out.println("Creating an empty table...");

        if (repeat == 1){
            TicTacToe ticTacToe = new TicTacToe();
        }else{
            TicTacToe ticTacToe = new TicTacToe(repeat);
        }


    }
}