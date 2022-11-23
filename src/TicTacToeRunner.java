import java.util.Scanner;

public class TicTacToeRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe("");

        System.out.println("Welcome to TicTacToe!");
        System.out.println("You will be versing a bot.");

        String symbol = "o";
        while (true) {
            System.out.print("Choose your desired symbol (Note: bot uses symbol 'x' already): ");
            symbol = scan.nextLine();
            if (symbol.length() > 1){
                System.out.println("Your symbol length is too big.");
                System.out.println("Type only one character.");
            }else if (symbol.equals("1") || symbol.equals("2") || symbol.equals("3") || symbol.equals("4") || symbol.equals("5") || symbol.equals("6") || symbol.equals("7") || symbol.equals("8") || symbol.equals("9")){
                System.out.println("Your symbol cannot be a number.");
            }else if (symbol.equalsIgnoreCase("x")){
                System.out.println("The bot uses symbol 'x' already.");
                System.out.println("Try again.");
            }else{
                break;
            }
        }

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

        if (repeat == 1){
            ticTacToe = new TicTacToe(symbol);
        }else{
            ticTacToe = new TicTacToe(symbol,repeat);
        }

        for(int i = 0; i < repeat; i++) { //Loop repeats until it reaches user's repeat input
            System.out.println("Creating an empty table...");
            System.out.print(ticTacToe.printTable("1", "2", "3", "4", "5", "6", "7", "8", "9"));

            String spot = "";
            while(true) {
                while (true) {
                    System.out.print("Input a number from the table for your move: ");
                    spot = scan.next();
                    if (!(ticTacToe.getTable().contains(spot))) {
                        System.out.println("Please input a number that's on the table.");
                        System.out.println("Try again.");
                    } else {
                        break;
                    }
                }

                ticTacToe.userPlay(spot, symbol);
                if (ticTacToe.checkWin()){
                    break;
                }
                ticTacToe.botPlay();

                //if (!(ticTacToe.getTable().contains("1")) && !(ticTacToe.getTable().contains("2")) && !(ticTacToe.getTable().contains("3")) && !(ticTacToe.getTable().contains("4")) && !(ticTacToe.getTable().contains("5")) && !(ticTacToe.getTable().contains("6")) && !(ticTacToe.getTable().contains("7")) && !(ticTacToe.getTable().contains("8")) &&  !(ticTacToe.getTable().contains("9"))){ //Loop stops when the table is full
                //}
                if (ticTacToe.checkWin()){
                    break;
                }
            }
            System.out.println("Current Standings: " + ticTacToe.getUserScore()  + "-" + ticTacToe.getBotScore());
        }

        int userScore = ticTacToe.getUserScore();
        int botScore = ticTacToe.getBotScore();
        int difference = Math.abs(userScore - botScore);
        String plural = "";
        System.out.println("Final Results: " + userScore + "-" + botScore);
        if (userScore > botScore){
            System.out.println("You win!");
            if (difference > 1){
                plural = "s";
            }
            System.out.println("You beat the bot by " + difference +" point" + plural + "!");
            System.out.println("Great job!");
        }else if(userScore < botScore){
            System.out.println("The bot wins!");
            if (difference > 1){
                plural = "s";
            }
            System.out.println("The bot beats you by " + difference +" point" + plural + "!");
            System.out.println("Better luck next time!");
        }else{
            System.out.println("Tie!");
            System.out.println("What a fierce battle!");
        }

        System.out.println();
        if (repeat == 1){
            System.out.println("Thank you for playing TicTacToe!");
        }else {
            System.out.println("Thank you for playing TicTacToe " + repeat + " times!");
        }
    }
}