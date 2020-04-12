import java.util.Random;
import java.util.Scanner;

public class Game{
    static final char xSign = 'X';
    static final char oSign = 'O';

    char getChar(){
        Scanner letter = new Scanner(System.in);
        String playerMove = letter.next();
        return playerMove.charAt(0);
    }

    int getRandomNum(){
        Random random = new Random();
        //Generates a number between 0-7
        return random.nextInt(8) + 1;
    }

    private String getStr(){
        Scanner st = new Scanner(System.in);
        return st.next();
    }

    int moveChoice(){
        while (true){
            String c = getStr();
            int i = Integer.parseInt(c);
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9) {
                return i;
            } else {
                return 0;
            }
        }
    }
}
