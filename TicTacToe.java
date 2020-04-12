//Again with the no packages bruh

public class TicTacToe extends Game {
    private static final char[][] field = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    private static final String gameOver = "Game over :(";
    private static final String playerOrMachine = "Would you like to play with another player or play with the computer? Type P or M to choose.";
    private static final String playerChoice = "You have a choice between using the X-Marker or O-Marker!";
    private static final String xFirstPlayer = "The player who chooses X will be Player One. The person who chooses O will be Player Two.";
    private static final String oFirstPlayer = "The player who chooses O will be Player One. The person who chooses X will be Player Two.";
    private static final String mustChoose = "You must choose between either X or O. ";
    private static final String P = "P";
    private static final String M = "M";
    private static final String smile = ":)";
    private static final String draw = "It was a draw!";

    private GameState initVar = new GameState(field, 0, false);

    void playWithPlayerOrMachine() {
        System.out.println(playerOrMachine);
        while (true) {
            char ch = getChar();
            String s = ("" + ch).toLowerCase();
            if (s.equals(P)) {
                playWithPlayer();
                return;
            } else if (s.equals(M)) {
                playWithMachine();
                return;
            }
        }
    }

    private void playWithMachine() {
        choiceXorO();
        while (!initVar.getIsGameOver()) {
            initVar.displayGameField();
            initVar.isTheCellUnderTheDigit(moveChoice());
            initVar.checkWinner();
            checkDraw();
            initVar.nextTurn();
            if (initVar.getIsGameOver()) {
                return;
            } else {
                initVar.machineStrokeSelection(getRandomNum());
                initVar.checkWinner();
                checkDraw();
                initVar.nextTurn();
            }
        }
    }

    private void playWithPlayer() {
        choiceXorO();
        while (!initVar.getIsGameOver()) {
            initVar.displayGameField();
            initVar.isTheCellUnderTheDigit(moveChoice());
            initVar.checkWinner();
            checkDraw();
            initVar.nextTurn();
        }
    }

    private void choiceXorO() {
        System.out.println(playerChoice);
        boolean check = false;
        while (!check) {
            switch (getChar()) {
                case xSign:
                    System.out.println(xFirstPlayer);
                    initVar.setPlayerTurn(1);
                    check = true;
                    break;
                case oSign:
                    System.out.println(oFirstPlayer);
                    initVar.setPlayerTurn(2);
                    check = true;
                    break;
                default:
                    System.out.println(mustChoose);
            }
        }
    }

    private void checkDraw() {
        int checkGameField = 0;
        char[][] gameField = initVar.getPlayField();
        boolean check = initVar.getIsGameOver();
        if (check) {
            System.out.println(smile);
            initVar.displayGameField();
        } else {
            for (int row = 0; row < gameField.length; row++) {
                for (int colum = 0; colum < gameField[row].length; colum++) {
                    if (xSign == gameField[row][colum] || oSign == gameField[row][colum]) {
                        checkGameField++;
                    }
                    if (9 == checkGameField) {
                        initVar.displayGameField();
                        System.out.println(draw + gameOver());
                        initVar.setGameOver(true);
                    }
                }
            }
        }
    }

    private String gameOver() {
        return gameOver;
    }

}
