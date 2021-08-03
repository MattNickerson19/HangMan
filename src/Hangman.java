import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.util.List;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("words.txt"));
        Scanner inputDevice = new Scanner(System.in);

        List<String> wordBank = new ArrayList<>();
        while (fileScanner.hasNext()){
           wordBank.add(fileScanner.nextLine());
        }

        Random rand = new Random();
        String wordToGuess = wordBank.get(rand.nextInt(wordBank.size()));

        List<Character> playerGuesses = new ArrayList<>();

        displayWord(wordToGuess, playerGuesses);

        System.out.println("Please Guess a Letter>>");
        String letterGuessed = inputDevice.nextLine();
        playerGuesses.add(letterGuessed.charAt(0));
        displayWord(wordToGuess, playerGuesses);


        int incorrectGuesses = 0;
        while (true) {
            printOutMan(incorrectGuesses);
            System.out.println("Letters Guessed: " + playerGuesses);

            if (incorrectGuesses >= 6){
                System.out.println("You Lose!");
                break;
            }
            if (!getPlayerGuess(inputDevice, wordToGuess, playerGuesses)){
                incorrectGuesses++;
            }
            if(displayWord(wordToGuess, playerGuesses)){
                System.out.println("Correctly Guessed word, You Win!");
                break;
            }
        }


    }
    private static boolean displayWord(String wordToGuess, List<Character> playerGuesses){
        int correctGuesses = 0;
        for(int i = 0; i < wordToGuess.length(); i++){
            if (playerGuesses.contains(wordToGuess.charAt(i))){
                System.out.print(wordToGuess.charAt(i));
                correctGuesses ++;
            }
            else{
                System.out.print("_");
            }
        }
        System.out.println();



        return (wordToGuess.length() == correctGuesses);
    }
    private static boolean getPlayerGuess(Scanner inputDevice, String wordToGuess, List<Character> playerGuesses){
        System.out.println("Please Guess a Letter>>");
        String letterGuessed = inputDevice.nextLine();
        playerGuesses.add(letterGuessed.charAt(0));

        return (wordToGuess.contains(letterGuessed));
    }

    private static void printOutMan(Integer incorrectGuesses){
        System.out.println(" --------");
        System.out.println(" |      |");
        if (incorrectGuesses >= 1){
            System.out.println(" O");
        }
        if (incorrectGuesses >= 2) {
            System.out.print("\\ ");
            if (incorrectGuesses >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }
        if (incorrectGuesses >= 4){
            System.out.println(" |");
        }
        if (incorrectGuesses >= 5) {
            System.out.print("/ ");
            if (incorrectGuesses >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
    }
}
