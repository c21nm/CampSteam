import java.util.Scanner;

public class Tester{

    public static void main(String [] args){

        System.out.println("Enter the word to guess");
        Scanner scan = new Scanner(System.in);
        String inputWord = scan.nextLine();

        String lettersGuessed= "";
        Board board = new Board(inputWord);

        String input;

        boolean correct = false;

        while (board.getLives() > 0 ){ 

            if(board.allLettersFilled()){
                break;
            }

            System.out.println("Lives: " + board.getLives() + " LETTERS FILLED: " + board.allLettersFilled());

             if(board.getLives()  == 6){
                System.out.println(Hangman.base());
             }
             if(board.getLives()==5) {
                System.out.println(Hangman.strikeOne());
             }
             if(board.getLives()== 4){
                System.out.println(Hangman.strikeTwo());
             } 
             if(board.getLives()== 3){
                System.out.println(Hangman.strikeThree());
             }
             if(board.getLives()== 2){
                System.out.println(Hangman.strikeFour());
             }
             if(board.getLives() == 1){
                System.out.println(Hangman.strikeFive());
             }

            if(!board.getIncorrectGuesses().equals("\n")){
                System.out.println("Letters Guessed: " + board.getIncorrectGuesses());
            }

            System.out.println(board.toString());
            System.out.println("Enter your guess");

            input = scan.nextLine();
            input = input.substring(0,1);

            correct = board.setMove(input);
            board.updateNumberOfLives(correct);

            if(!correct){
                lettersGuessed += input + " ";
            }
        }

        if(!correct){
            System.out.println(Hangman.strikeSix());
        }
        else{
            System.out.println(board.toString());
            System.out.println("VICTORY!");
        }
       
    }
}
