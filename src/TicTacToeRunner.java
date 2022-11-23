import java.util.Scanner;

public class TicTacToeRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe("");

        System.out.println("Welcome to TicTacToe!"); //Introduction
        System.out.println("You will be versing a bot.");

        String symbol = "o";
        while (true) { //Loops until the user inputs an appropriate symbol
            System.out.print("Choose your desired symbol (Note: bot uses symbol 'x' already): ");
            symbol = scan.nextLine();
            if (symbol.length() > 1){ //Symbol cannot be greater than the length of one
                System.out.println("Your symbol length is too big.");
                System.out.println("Type only one character.");
            }else if (symbol.equals("1") || symbol.equals("2") || symbol.equals("3") || symbol.equals("4") || symbol.equals("5") || symbol.equals("6") || symbol.equals("7") || symbol.equals("8") || symbol.equals("9")){ //Symbol cannot be a number
                System.out.println("Your symbol cannot be a number.");
            }else if (symbol.equalsIgnoreCase("x")){ //Symbol cannot be the bot's symbol
                System.out.println("The bot uses symbol 'x' already.");
                System.out.println("Try again.");
            }else{
                break;
            }
        }

        boolean isIntGreaterThanOne = true;
        int repeat = 0;
        while (isIntGreaterThanOne) { //Loops until the user inputs a valid integer greater than 0
            System.out.print("How many times do you want the game to repeat? ");
            repeat = scan.nextInt(); //Stores a 'repeat' variable that is later used for the parameter
            if (repeat <= 0) {
                System.out.println("Please enter a valid integer greater than 0.");
                System.out.println("Try again.");
                System.out.println();
            }else{
                isIntGreaterThanOne = false;
            }
        }

        if (repeat == 1){
            ticTacToe = new TicTacToe(symbol); //Replays the game one time only; User's symbol is used
        }else{
            ticTacToe = new TicTacToe(symbol,repeat); //Replays the game of the user's number; User's symbol is used
        }

        for(int i = 0; i < ticTacToe.getRepeat(); i++) { //Loop repeats until it reaches user's repeat input
            System.out.println("Creating an empty table..."); //Creates an empty table for the start of every round
            System.out.print(ticTacToe.printTable("1", "2", "3", "4", "5", "6", "7", "8", "9"));

            String spot = "";
            while(true) { //Loops until the user or the bot wins
                while (true) { //Loop to ensure that the user inputs a valid number that's on the table
                    System.out.print("Input a number from the table for your move: ");
                    spot = scan.next();
                    if (!(ticTacToe.getTable().contains(spot))) {
                        System.out.println("Please input a number that's on the table.");
                        System.out.println("Try again.");
                    } else {
                        break;
                    }
                }

                ticTacToe.userPlay(spot, symbol); //Calculates user's play
                if (ticTacToe.checkWin()){ //Checks if the user has won before the bot makes its move
                    break; //Breaks loop as soon as the user wins
                }

                ticTacToe.botPlay(); //Calculates bot's play
                if (ticTacToe.checkWin()){ //Checks if the bot has won before the next move happens
                    break; //Breaks loop as soon as the bot wins
                } //Loop will break if there's a tie
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