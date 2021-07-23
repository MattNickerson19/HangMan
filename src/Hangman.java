import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner inputDevice = new Scanner(System.in);
        String wordToGuess;
        int wordLength;
        int wordToGuessLength;
        int position;
        int livesLost = 0;
        int totalLives = 7;
        int lettersRemaining;
        boolean guessInWord;
        char guess;
        StringBuffer sb = new StringBuffer();
        StringBuffer previouslyGuessChar;
        StringBuffer buffer = new StringBuffer();

        String[] wordBank = new String[]{"watermelon", "waterfall", "candlestick", "courtyard", "notebook", "bicycle", "mountain",
                                        "firework", "computer", "python", "tomato", "hockey"};

        System.out.println("Welcome to Hangman");

        wordToGuess = wordBank[(int) (Math.random() * wordBank.length)];
        wordToGuessLength = wordToGuess.length();
        System.out.println("Your word has " + wordToGuessLength + " Letters");
        lettersRemaining = wordToGuessLength;

        for (position = 0; position < wordToGuessLength; position++){
            sb.append("_ ");
        }
        System.out.println(sb.toString());

        while (lettersRemaining > 0 && livesLost < 7){
            System.out.println("\nPlease Guess a Letter>>");
            guess = inputDevice.next().charAt(0);
            guessInWord = (wordToGuess.indexOf(guess)) != -1;

            if (guessInWord == false){
                livesLost++;
                System.out.print("Incorrect Guess! " + (totalLives - livesLost) + " Lives left");
            }
            else{
                System.out.println("Correct Guess");
                for(position = 0; position < wordToGuessLength; position++){
                    if( wordToGuess.charAt(position) == guess){
                        System.out.print(guess);
                        lettersRemaining --;
                    }
                    else {
                        System.out.print("_ ");
                    }
                }
            }
            System.out.println();
            previouslyGuessChar = buffer.append(guess);
            System.out.print("Previously guessed letters: " + previouslyGuessChar + "\nLetters remaining: "+ lettersRemaining);



        }
    }
}
