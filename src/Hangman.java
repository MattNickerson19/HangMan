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

        System.out.println(wordToGuess);

        List<Character> playerGuesses = new ArrayList<>();

        displayWord(wordToGuess, playerGuesses);

        System.out.println("Please Guess a Letter>>");
        String letterGuessed = inputDevice.nextLine();
        playerGuesses.add(letterGuessed.charAt(0));
        displayWord(wordToGuess, playerGuesses);

        while (true) {
            getPlayerGuess(inputDevice, wordToGuess, playerGuesses);
            if(displayWord(wordToGuess, playerGuesses)){
                break;
            }
        }
        System.out.println("Correctly Guessed word, You Win!");





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
    private static void getPlayerGuess(Scanner inputDevice, String wordToGuess, List<Character> playerGuesses){
        System.out.println("Please Guess a Letter>>");
        String letterGuessed = inputDevice.nextLine();
        playerGuesses.add(letterGuessed.charAt(0));

    }
}
