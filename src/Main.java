import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a 5 letter word: ");

        String word = scanner.nextLine().toLowerCase();

        if (word.length() != 5 || !word.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input");
            return;
        }

        int attempts = 7;

        System.out.println("Guess the word which contains 5 letters. " + "You have " + attempts + " attempts:");

        String guessed = "_____";

        while (attempts > 0) {
            String letter = scanner.nextLine().toLowerCase();
            if (word.contains(letter)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter.charAt(0)) {
                        guessed = guessed.substring(0, i) + letter.charAt(0) + guessed.substring(i + 1);
                    }
                }
                System.out.println(guessed);
                if (word.equals(guessed)) {
                    break;
                }
                System.out.println("Nice! Type your guess: ");
            } else {
                attempts--;
                if (attempts == 0) {
                    break;
                }
                System.out.println(guessed);
                System.out.println("Wrong... " + "You have " + attempts + " attempts left. " + "Type your guess: ");
            }
        }
        System.out.println(!guessed.equals(word) ? "Too Bad... The word is: " + word : "Congratulations! You guessed the word!");
    }
}