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

    //"repeat" parameter that counts how many rounds are played
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
    public int getRepeat(){
        return repeat; //Gets repeat count
    }
    public int getBotScore(){
        return botScore; // Returns the bot's current score
    }

    public int getUserScore(){
        return userScore; // Returns the user's current score
    }

    public String getTable(){
        return table; // Returns the current table which includes what spots are occupied and what spots are open
    }
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

    public void userPlay(String spot, String symbol){
        System.out.println("Your move: ");
        calcSpot(spot,symbol); //User's Move based on user's inputted spot number and their desired symbol
    }

    public void botPlay(){
        Integer randNum = 0;
        while (true) { //Repeats randomizer until the bot finds an empty spot
            randNum = (int) (Math.random() * 9 + 1);
            if (getTable().contains(randNum.toString())){
                break;
            }
        }
        System.out.println("Bot's move:");
        calcSpot(randNum.toString(), "x"); //Bot's Move
    }

    public void calcSpot(String spot, String symbol){
        //Sets one of the indexes of the table to user's/bot's symbol based on the user's/bot's inputted spot number
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

        //Reprints the table after every move
        System.out.println(printTable(indexOne,indexTwo,indexThree,indexFour,indexFive,indexSix,indexSeven,indexEight,indexNine));
    }

    public boolean checkWin(){ //Checks every winning possibility in TicTacToe. Returns true when as soon as there's an available win; Returns false otherwise. Adds to the user's/bot's score after every win.
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
