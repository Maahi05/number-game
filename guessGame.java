import java.util.*;

class guessGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        String playAgain;

        do {
            int randomNumber = rand.nextInt(100) + 1;

            System.out.print("Enter number of attempts: ");
            while (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive integer for attempts.");
                in.next(); // consume invalid token
            }
            int attempts = in.nextInt();
            if (attempts <= 0) {
                System.out.println("Attempts must be positive. Setting attempts to 10.");
                attempts = 10;
            }

            boolean guessedCorrect = false;

            System.out.println("\nGuess the number between 1 and 100");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                while (!in.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer for your guess.");
                    in.next(); // consume invalid token
                }
                int guess = in.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Correct! You guessed it!");
                    score++;
                    guessedCorrect = true;
                    break;
                } 
                else if (guess < randomNumber) {
                    System.out.println("Too low!");
                } 
                else {
                    System.out.println("Too high!");
                }

                attempts--;
                System.out.println("Remaining attempts: " + attempts);
            }

            if (!guessedCorrect) {
                System.out.println("Game Over! Number was: " + randomNumber);
            }

            System.out.println("Your score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = in.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Final Score: " + score);
        in.close();
    }
}