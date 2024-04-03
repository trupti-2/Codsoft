import java.util.Random;
import java.util.Scanner;
public class number {
    public static void main(String[] args) {
// create instance of Random class.
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int secretNumber = r.nextInt(100) +1;
        int attempts = 0;
        boolean guessed = false;
        System.out.println("NUmber Game");
        while (!guessed) {
            System.out.println("enter guess no:");
            int guess = sc.nextInt();
            attempts++;
            if(guess == secretNumber){
                System.out.println(" Congratulations ! Your guessed no in "  + attempts  +"  attempts");
                guessed = true;
            } else if (guess<secretNumber) {
                System.out.println("Try a higher number:");

            }else{
                System.out.println("Try a lower number:");
            }

        }
        sc.close();
    }
}

