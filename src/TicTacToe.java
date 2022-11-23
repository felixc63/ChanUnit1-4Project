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
    }

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
    }
    public int getBotScore(){
        return botScore;
    }

    public int getUserScore(){
        return userScore;
    }

    public String getTable(){
        return table;
    }
    public String printTable(String one, String two, String three, String four, String five, String six, String seven, String eight, String nine){
        String table = ("|---|---|---|") + "\n";
        table += ("| " + one + " | " + two + " | " + three + " |") + "\n";
        table += ("|-----------|") + "\n";
        table += ("| " + four + " | " + five + " | " + six + " |") + "\n";
        table += ("|-----------|") + "\n";
        table += ("| " + seven + " | " + eight + " | " + nine + " |") + "\n";
        table += ("|---|---|---|") + "\n";

        indexOne = table.substring(table.indexOf(one), table.indexOf(one)+1);
        indexTwo = table.substring(table.indexOf(two), table.indexOf(two)+1);
        indexThree = table.substring(table.indexOf(three), table.indexOf(three)+1);
        indexFour = table.substring(table.indexOf(four), table.indexOf(four)+1);
        indexFive = table.substring(table.indexOf(five), table.indexOf(five)+1);
        indexSix = table.substring(table.indexOf(six), table.indexOf(six)+1);
        indexSeven = table.substring(table.indexOf(seven), table.indexOf(seven)+1);
        indexEight = table.substring(table.indexOf(eight), table.indexOf(eight)+1);
        indexNine = table.substring(table.indexOf(nine), table.indexOf(nine)+1);

        this.table = table;

        return table;
    }

    public void calcSpot(String spot, String symbol){
        if(spot.equals("1")){
            System.out.println(printTable(symbol,indexTwo,indexThree,indexFour,indexFive,indexSix,indexSeven,indexEight,indexNine));
        }else if(spot.equals("2")){
            System.out.println(printTable(indexOne,symbol,indexThree,indexFour,indexFive,indexSix,indexSeven,indexEight,indexNine));
        }else if(spot.equals("3")){
            System.out.println(printTable(indexOne,indexTwo,symbol,indexFour,indexFive,indexSix,indexSeven,indexEight,indexNine));
        }else if(spot.equals("4")){
            System.out.println(printTable(indexOne,indexTwo,indexThree,symbol,indexFive,indexSix,indexSeven,indexEight,indexNine));
        }else if(spot.equals("5")){
            System.out.println(printTable(indexOne,indexTwo,indexThree,indexFour,symbol,indexSix,indexSeven,indexEight,indexNine));
        }else if(spot.equals("6")){
            System.out.println(printTable(indexOne,indexTwo,indexThree,indexFour,indexFive,symbol,indexSeven,indexEight,indexNine));
        }else if(spot.equals("7")){
            System.out.println(printTable(indexOne,indexTwo,indexThree,indexFour,indexFive,indexSix,symbol,indexEight,indexNine));
        }else if(spot.equals("8")){
            System.out.println(printTable(indexOne,indexTwo,indexThree,indexFour,indexFive,indexSix,indexSeven,symbol,indexNine));
        }else if(spot.equals("9")){
            System.out.println(printTable(indexOne,indexTwo,indexThree,indexFour,indexFive,indexSix,indexSeven,indexEight,symbol));
        }
    }
    public void userPlay(String spot, String symbol){
        System.out.println("Your move: ");
        calcSpot(spot,symbol); //User Move

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
        calcSpot(randNum.toString(), "x"); //Bot Move
    }

    public boolean checkWin(){ //Checks every winning possibility in TicTacToe
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
        if (indexThree.equals(indexFive) && indexFour.equals(indexSeven)){
            if (indexThree.equals(symbol)){
                userScore++;
            }else{
                botScore++;
            }
            return true;
        }else{
            return false;
        }
    }
}
