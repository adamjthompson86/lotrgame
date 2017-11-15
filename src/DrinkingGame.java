
import java.util.*;
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
      opponent = drinkingOpponent();
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
      System.out.println("No pauses, no spills. And no regurgitation! Aye, last one standing wins!");
      do {
         Game.pauseGame(1);
         System.out.println("Glug...");
         Game.pauseGame(1);
         System.out.println(opponent + " has had " + ++opponentCurrentDrinks + " drinks");
         System.out.println("You've had " + ++characterCurrentDrinks + " of " + characterMaxDrinks + " drinks");

         if (characterCurrentDrinks == 8) {
            System.out.println("\u266B " + drinkingQuote());
         }

         if ((characterCurrentDrinks >= characterMaxDrinks) || (opponentCurrentDrinks >= opponentMaxDrinks)) {
            System.out.println("What did I say? He can't hold his liquor!");
            Game.pauseGame(2);
            System.out.println("...CRASH...");
            Game.pauseGame(2);
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

   public String drinkingQuote() {
      ArrayList<String> quotes = new ArrayList<String>();
      quotes.add("I feel something. A slight tingling in my fingers.");
      quotes.add("It's the Dwarves that go swimming with little, hairy women!");
      quotes.add("Give me your name, horse-master, and I shall give you mine!");
      quotes.add("It's true you don't see many Dwarf-women. And in fact, they are so alike in voice and appearance, that they are often mistaken for Dwarf-men.");
      quotes.add("You'll find more cheer in a graveyard.");
      quotes.add("Whatever luck you live by... let's hope it lasts the night.");
      quotes.add("That was deliberate, it was deliberate.");
      quotes.add("Keep breathing. That's the key. Breathe.");
      quotes.add("That still only counts as one.");
      quotes.add("Certainty of death. Small chance of success. What are we waiting for?");
      quotes.add("There's plenty for the both of us, may the best Dwarf win.");
      quotes.add("Soon, you will enjoy the fabled hospitality of the Dwarves.");
      quotes.add("I have the eyes of a hawk and the ears of a fox.");
      quotes.add("Not the beard!");
      Random randomizer = new Random();
      String randomQuote = quotes.get(randomizer.nextInt(quotes.size()));
      return randomQuote;
   }
   
      public String drinkingOpponent() {
      ArrayList<String> opponent = new ArrayList<String>();
      opponent.add("Gimli");
      opponent.add("Legolas");
      opponent.add("Eomer");
      opponent.add("Pippin");
      opponent.add("Merry");
      Random randomizer = new Random();
      String randomOpponent = opponent.get(randomizer.nextInt(opponent.size()));
      return randomOpponent;
   }
}
