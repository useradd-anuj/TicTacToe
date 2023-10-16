import java.io.IOException;
import java.util.Scanner;

/**
 * @author Anuj
 * @version Date: 2023-10-11
 */

public class TicTacToe {
    private String[][] block= {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
    };

    static String[] player = new String[2];


        public static void clear()
        {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException | IOException e) {
            }
        }

    public static void main(String[] args) {
        TicTacToe obj = new TicTacToe();
        Scanner s = new Scanner(System.in);

        System.out.print("Player 1:- ");
        player[0] = s.nextLine();
        System.out.print("Player 2:- ");
        player[1] = s.nextLine();

        //randomly selecting one for X or O
        //X starts

        int index = (int)(Math.random()*2);

        if(index==1){
            String tmp = player[0];
            player[0] = player[1];
            player[1] = tmp;
        }
        clear();
        System.out.println(player[0]+" has got X and starts the game");
        //Player at index 0 starts with X
        //player[0] x player[1] O
        int tempCount = 0;
        do{
            obj.displayBlock();
            if(tempCount%2==0) {
                System.out.print(player[0]);
                System.out.println(" Enter the block number");
                obj.input(s.next(),true);
            }
            else {
                System.out.println(player[1]);
                System.out.println(" Enter the block number");
                obj.input(s.next(),false);
            }
            tempCount++;


        }while(obj.check());


    }

    void input(String block_num,boolean evenIn){
        for(int i=0;i<block.length;i++) {
            for (int j = 0; j < block[0].length; j++) {
                if(block_num.equals(block[i][j]))
                    if(evenIn)
                        block[i][j] = "X";
                    else
                        block[i][j] = "O";
            }
        }
    }

    void displayBlock(){

        clear();
        for(int i=0;i<block.length;i++){
            for(int j=0;j<block[0].length;j++){
                System.out.print("|"+block[i][j]);
            }
            System.out.println("|");
        }
    }

    boolean check(){
        if(block[0][0].equals(block[0][1])&&block[0][1].equals(block[0][2])){
            if(block[0][0].equals("X")){
                System.out.println(player[0]+" won");
                return false;
            }
            else if(block[0][0].equals("O")){
                System.out.println(player[1]+" won");
                return false;
            }
        }

        if(block[1][0].equals(block[1][1])&&block[1][1].equals(block[1][2])){
            if(block[1][0].equals("X")){
                System.out.println(player[0]+" won");
                return false;
            }
            else if(block[1][0].equals("O")){
                System.out.println(player[1]+" won");
                return false;
            }
        }

        if(block[2][0].equals(block[2][1])&&block[2][1].equals(block[2][2])){
            if(block[2][0].equals("X")){
                System.out.println(player[0]+" won");
                return false;
            }
            else if(block[2][0].equals("O")){
                System.out.println(player[1]+" won");
                return false;
            }
        }

        if(block[0][0].equals(block[1][0])&&block[1][0].equals(block[2][0])){
            if(block[1][0].equals("X")){
                System.out.println(player[0]+" won");
                return false;
            }
            else if(block[1][0].equals("O")){
                System.out.println(player[1]+" won");
                return false;
            }
        }

        if(block[0][1].equals(block[1][1])&&block[1][1].equals(block[2][1])){
            if(block[1][1].equals("X")){
                System.out.println(player[0]+" won");
                return false;
            }
            else if(block[1][1].equals("O")){
                System.out.println(player[1]+" won");
                return false;
            }
        }

        if(block[0][2].equals(block[1][2])&&block[1][2].equals(block[2][2])){
            if(block[1][2].equals("X")){
                System.out.println(player[0]+" won");
                return false;
            }
            else if(block[1][2].equals("O")){
                System.out.println(player[1]+" won");
                return false;
            }
        }

        if(block[0][0].equals(block[1][1])&&block[1][1].equals(block[2][2])){
            if(block[0][0].equals("X")){
                System.out.println(player[0]+" won");
                return false;
            }
            else if(block[0][0].equals("O")){
                System.out.println(player[1]+" won");
                return false;
            }
        }

        if(block[2][0].equals(block[1][1])&&block[1][1].equals(block[0][2])){
            if(block[1][1].equals("X")){
                System.out.println(player[0]+" won");
                return false;
            }
            else if(block[1][1].equals("O")){
                System.out.println(player[1]+" won");
                return false;
            }
        }


        return true;
    }
}
