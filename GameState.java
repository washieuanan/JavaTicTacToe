//IntelliJ won't give packages??  Bruh moment

public class GameState extends Game {
    private static final String FIELD = "Select a field";
    private static final String playerWon = " Player Wins";
    private char[][] playField;
    private int playerTurn;
    private boolean isGameOver;

    GameState(char[][] playField, int playCount, boolean checkForGame) {
        this.playField = playField;
        this.playerTurn = playCount;
        this.isGameOver = checkForGame;
    }

    void nextTurn() {
        this.playerTurn = playerTurn + 1;
    }

    char[][] getPlayField() {
        return playField;
    }

    boolean getIsGameOver() {
        return isGameOver;
    }

    void setPlayerTurn(int i) {
        this.playerTurn = i;
    }

    void setGameOver(boolean f) {
        this.isGameOver = f;
    }

    void isTheCellUnderTheDigit(int i) {
        int cell = i - 1;
        int count = 0;
        for (int row = 0; row < playField.length; row++) {
            for (int colum = 0; colum < playField[row].length; colum++) {
                if (cell == count && playField[row][colum] != xSign && playField[row][colum] != oSign) {
                    playField[row][colum] = whoPlay();
                    return;
                }
                count++;
            }
        }
        System.out.println(FIELD);
        isTheCellUnderTheDigit(moveChoice());
    }

    void machineStrokeSelection(int i) {
        boolean f = false;
        int cell = i - 1;
        while (!f) {
            int count = 0;
            for (int row = 0; row < playField.length; row++) {
                for (int colum = 0; colum < playField[row].length; colum++) {
                    if (cell == count && playField[row][colum] != xSign && playField[row][colum] != oSign) {
                        playField[row][colum] = whoPlay();
                        f = true;
                        return;
                    }
                    count++;
                }
            }
            cell = getRandomNum() - 1;
        }
    }

    private char whoPlay() {
        if (1 == playerTurn % 2) {
            return xSign;
        } else {
            return oSign;
        }
    }

    void checkWinner() {
        //Looking through both the row and the column
        for (int row = 0; row < playField.length; row++) {
            int countCheckRow = 0;
            int countCheckColum = 0;
            for (int colum = 0; colum < playField[row].length; colum++) {
                if (playField[row][colum] == whoPlay()) {
                    countCheckColum++;
                }
                if (playField[colum][row] == whoPlay()) {
                    countCheckRow++;
                }
                if (3 == countCheckColum) {
                    this.isGameOver = true;
                    System.out.println(whoPlay() + playerWon);
                    return;
                }
                if (3 == countCheckRow) {
                    this.isGameOver = true;
                    System.out.println(whoPlay() + playerWon);
                    return;
                }
            }
        }

        if ((playField[0][0] == whoPlay() && playField[1][1] == whoPlay() && playField[2][2] == whoPlay())
                || (playField[2][0] == whoPlay() && playField[1][1] == whoPlay() && playField[0][2] == whoPlay())) {
            this.isGameOver = true;
            System.out.println(whoPlay() + playerWon);

        }
    }

    void displayGameField(){
        System.out.println();
        for(int row = 0; row<playField.length; row++){
            System.out.println(" -------------");
            for(int colum = 0; colum<playField[row].length; colum++){
                System.out.print(" | "+playField[row][colum]);
            }
            System.out.println(" |");
        }
        System.out.println(" -------------");
    }


}
