
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DrinkingGame {

   String opponent;
   int opponentMaxDrinks;
   int characterMaxDrinks;
   int opponentCurrentDrinks;
   int characterCurrentDrinks;

   public DrinkingGame(int a) {
      characterMaxDrinks = a;
      opponentCurrentDrinks = 0;
      characterCurrentDrinks = 0;
      // Choose opponent
      opponent = "Gimli";
      //set winning number of drinks    
      Random rand = new Random();
      int maxDrinks = rand.nextInt(10) + 10;
      opponentMaxDrinks = maxDrinks;
   }

   public void printStats() {
      System.out.println("Opponent: " + opponent);
      System.out.println("Your Max Drinks: " + characterMaxDrinks);
      System.out.println("Opponent Max Drinks: " + characterMaxDrinks);
   }

   public boolean drink() {
      boolean drinkingGameOn = true;
      System.out.println("No pauses, no spills. And no regurgitation! Aye, Last one standing wins!");
      do {
         System.out.println("Glug...");
         try {
            TimeUnit.SECONDS.sleep(1);
         } catch (InterruptedException ex) {
            Logger.getLogger(DrinkingGame.class.getName()).log(Level.SEVERE, null, ex);
         }
         System.out.println("Glug...");
         try {
            TimeUnit.SECONDS.sleep(1);
         } catch (InterruptedException ex) {
            Logger.getLogger(DrinkingGame.class.getName()).log(Level.SEVERE, null, ex);
         }
         System.out.println(opponent + " has had " + ++opponentCurrentDrinks + " drinks");
         System.out.println("You've had " + ++characterCurrentDrinks + " of " + characterMaxDrinks + " drinks");

         if (characterCurrentDrinks == 8) {
            System.out.println("Hear, hear. It's the dwarves that go swimming with little hairy women!");
         }
         if (characterCurrentDrinks == 10) {
            System.out.println("I feel something. A slight tingling in my fingers.");
         }
         if ((characterCurrentDrinks >= characterMaxDrinks) || (opponentCurrentDrinks >= opponentMaxDrinks)) {
            System.out.println("What did I say? He can't hold his liquor!");
            try {
               TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
               Logger.getLogger(DrinkingGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("...CRASH...");
            try {
               TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
               Logger.getLogger(DrinkingGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Game over.");
            if ((characterMaxDrinks - characterCurrentDrinks) >= (opponentMaxDrinks - opponentCurrentDrinks)) {
               System.out.println("You win 5 coins.");
               return true;
            } else {
               System.out.println("You lose!");
            }
            drinkingGameOn = false;
         }

      } while (drinkingGameOn);
      return false;
   }

}
