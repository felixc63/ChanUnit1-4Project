/**
 * The TicTacToe class represents a game.
 * The game includes the user's score, the bot's score, the TicTacToe table, every index on the TicTacToe table,
 * the symbol that is used both by the bot and the user, and the number of repeats of the game.
 */
public class TicTacToe {
    private int botScore;
    private int userScore;
    private String table;
    private String indexOne;
    private String indexTwo;
    private String indexThree;
    private String indexFour;
    private String indexFive;
    private String indexSix;
    private String indexSeven;
    private String indexEight;
    private String indexNine;
    private String symbol;
    private int repeat;
    /**
     * Constructor for the TicTacToe class. This creates a new and clear instance of the TicTacToe game given
     * the below parameters.
     *
     * @param symbol represents the symbol used by the user/bot
     */

    public TicTacToe(String symbol){
        botScore = 0;
        userScore = 0;
        table = "";
        indexOne = "";
        indexTwo = "";
        indexThree = "";
        indexFour = "";
        indexFive = "";
        indexSix = "";
        indexSeven = "";
        indexEight = "";
        indexNine = "";
        this.symbol = symbol;
        this.repeat = 1;
    }
    /**
     * Constructor for the TicTacToe class. This creates a new and clear instance of the TicTacToe game given
     * the below parameters.
     *
     * @param symbol represents the symbol used by the user/bot
     * @param repeat represents the count of how many rounds are played
     */
    public TicTacToe(String symbol, int repeat){
        botScore = 0;
        userScore = 0;
        table = "";
        indexOne = "";
        indexTwo = "";
        indexThree = "";
        indexFour = "";
        indexFive = "";
        indexSix = "";
        indexSeven = "";
        indexEight = "";
        indexNine = "";
        this.symbol = symbol;
        this.repeat = repeat;
    }

    /**
     * getRepeat method for the TicTacToe class.
     * @return returns an int representing the repeat count of the game
     */
    public int getRepeat(){
        return repeat;
    }

    /**
     * getBotScore method for the TicTacToe class.
     * @return returns an int representing the bot's current score
     */
    public int getBotScore(){
        return botScore;
    }

    /**
     * getUserScore method for the TicTacToe class.
     * @return returns an int representing the user's current score
     */
    public int getUserScore(){
        return userScore;
    }

    /**
     * getTable method for the TicTacToe class.
     * @return returns a String that represents the current table which includes what spots are occupied and what spots are open
     */
    public String getTable(){
        return table;
    }

    /**
     * printTable method is used to print the next state of the table based on the user's/bot's move.
     * @param one represents index one of the table
     * @param two represents index two of the table
     * @param three represents index three of the table
     * @param four represents index four of the table
     * @param five represents index five of the table
     * @param six represents index six of the table
     * @param seven represents index seven of the table
     * @param eight represents index eight of the table
     * @param nine represents index nine of the table
     * @return returns a String that prints the updated state of the table
     */
    public String printTable(String one, String two, String three, String four, String five, String six, String seven, String eight, String nine){
        /* prints:
            |---|---|---|
            | 1 | 2 | 3 |
            |-----------|
            | 4 | 5 | 6 |
            |-----------|
            | 7 | 8 | 9 |
            |---|---|---|
         */
        String table = ("|---|---|---|") + "\n";
        table += ("| " + one + " | " + two + " | " + three + " |") + "\n";
        table += ("|-----------|") + "\n";
        table += ("| " + four + " | " + five + " | " + six + " |") + "\n";
        table += ("|-----------|") + "\n";
        table += ("| " + seven + " | " + eight + " | " + nine + " |") + "\n";
        table += ("|---|---|---|") + "\n";

        //Each spot on the TicTacToe table is stored
        indexOne = table.substring(table.indexOf(one), table.indexOf(one)+1);
        indexTwo = table.substring(table.indexOf(two), table.indexOf(two)+1);
        indexThree = table.substring(table.indexOf(three), table.indexOf(three)+1);
        indexFour = table.substring(table.indexOf(four), table.indexOf(four)+1);
        indexFive = table.substring(table.indexOf(five), table.indexOf(five)+1);
        indexSix = table.substring(table.indexOf(six), table.indexOf(six)+1);
        indexSeven = table.substring(table.indexOf(seven), table.indexOf(seven)+1);
        indexEight = table.substring(table.indexOf(eight), table.indexOf(eight)+1);
        indexNine = table.substring(table.indexOf(nine), table.indexOf(nine)+1);

        //Updates the table
        this.table = table;

        return table;
    }

    /**
     * toString method for the TicTacToe class.
     * @return returns a String that represents a blank table
     */
    public String toString(){
        return printTable("1","2","3","4","5","6","7","8","9");
    }

    /**
     * calcSpot method is used to calculate the user's/bot's move on the table.
     * Sets one of the indexes of the table to user's/bot's symbol based on the user's/bot's inputted spot number.
     * Reprints the table everytime the method is called.
     * @param spot represents what spot of the table is being used
     * @param symbol represents the symbol that the user/bot uses
     */
    public void calcSpot(String spot, String symbol){
        if(spot.equals("1")){
            indexOne = symbol;
        }else if(spot.equals("2")){
            indexTwo = symbol;
        }else if(spot.equals("3")){
            indexThree = symbol;
        }else if(spot.equals("4")){
            indexFour = symbol;
        }else if(spot.equals("5")){
            indexFive = symbol;
        }else if(spot.equals("6")){
            indexSix = symbol;
        }else if(spot.equals("7")){
            indexSeven = symbol;
        }else if(spot.equals("8")){
            indexEight = symbol;
        }else if(spot.equals("9")){
            indexNine = symbol;
        }

        System.out.println(printTable(indexOne,indexTwo,indexThree,indexFour,indexFive,indexSix,indexSeven,indexEight,indexNine));
    }

    /**
     * userPlay method will calculate their move given the user's input.
     * This method calls the calcSpot method.
     * @param spot represents the user's inputted spot they wish to play in
     * @param symbol represents the user's symbol
     */
    public void userPlay(String spot, String symbol){
        System.out.println("Your move: ");
        calcSpot(spot,symbol); //User's Move based on user's inputted spot number and their desired symbol
    }

    /**
     * botPlay method will randomize the bot's move and picks a spot that is not occupied.
     * This method calls the calcSpot method.
     */
    public void botPlay(){
        Integer randNum = 0;
        while (true) { //Repeats randomizer until the bot finds an empty spot
            randNum = (int) (Math.random() * 9 + 1);
            if (table.contains(randNum.toString())){
                break;
            }
        }
        System.out.println("Bot's move:");
        calcSpot(randNum.toString(), "x"); //Bot's Move
    }

    /**
     * checkWin method checks every winning possibility in the TicTacToe game.
     * Adds to the user's/bot's score after every win.
     * @return returns true when as soon as there's an available win or if all indexes of the game are filled: resulting in a tie.
     * Returns false otherwise.
     */
    public boolean checkWin(){
        //Horizontal wins
        if (indexOne.equals(indexTwo) && indexOne.equals(indexThree)){
            if (indexOne.equals(symbol)){
                userScore++;
            }else{
                botScore++;
            }
            return true;
        }
        if (indexFour.equals(indexFive) && indexFour.equals(indexSix)){
            if (indexFour.equals(symbol)){
                userScore++;
            }else{
                botScore++;
            }
            return true;
        }
        if (indexSeven.equals(indexEight) && indexSeven.equals(indexNine)){
            if (indexSeven.equals(symbol)){
                userScore++;
            }else{
                botScore++;
            }
            return true;
        }

        //Vertical wins
        if (indexOne.equals(indexFour) && indexOne.equals(indexSeven)){
            if (indexOne.equals(symbol)){
                userScore++;
            }else{
                botScore++;
            }
            return true;
        }
        if (indexTwo.equals(indexFive) && indexTwo.equals(indexEight)){
            if (indexTwo.equals(symbol)){
                userScore++;
            }else{
                botScore++;
            }
            return true;
        }
        if (indexThree.equals(indexSix) && indexThree.equals(indexNine)){
            if (indexThree.equals(symbol)){
                userScore++;
            }else{
                botScore++;
            }
            return true;
        }

        //Diagonal wins
        if (indexOne.equals(indexFive) && indexOne.equals(indexNine)){
            if (indexOne.equals(symbol)){
                userScore++;
            }else{
                botScore++;
            }
            return true;
        }
        if (indexThree.equals(indexFive) && indexThree.equals(indexSeven)) {
            if (indexThree.equals(symbol)) {
                userScore++;
            } else {
                botScore++;
            }
            return true;
        }

        //Checks if there are no available spots left on the table; Ends the round if there aren't any spots
        if (!(table.contains("1"))){
            if(!(table.contains("2"))){
                if(!table.contains("3")){
                    if(!table.contains("4")){
                        if (!table.contains("5")){
                            if(!table.contains("6")){
                                if (!table.contains("7")){
                                    if (!table.contains("8")){
                                        if(!table.contains("9")){
                                            System.out.println("Tie!");
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
