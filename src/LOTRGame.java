import java.util.Scanner;
import java.util.Random;

public class LOTRGame {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
 
       System.out.println("Welcome, traveler, to the Green Dragon Inn! What's your name?");
       Scanner scanIn = new Scanner(System.in);
       String characterName = scanIn.nextLine();
       String characterRace;
       boolean invalidRace;
       System.out.printf("Come on in, %s. ", characterName);
// Ask for race - only allow elf, human, hobbit, wizard, or dwarf
       do {
       System.out.printf("Pardon me for asking, but what race are you? %n", characterName);
       characterRace = scanIn.nextLine();
       invalidRace = (!characterRace.equalsIgnoreCase("elf") && !characterRace.equalsIgnoreCase("human") && !characterRace.equalsIgnoreCase("hobbit") && !characterRace.equalsIgnoreCase("wizard") && !characterRace.equalsIgnoreCase("dwarf"));
        if (invalidRace) {
          System.out.printf("Never heard of that. ");
        }
        else {
                    
       System.out.printf("'Tis a windy night out! Step on in by the fireplace, %s. We're always happy to welcome a friendly %s to our company!%n", characterName, characterRace);
        }
       } while (invalidRace);
// Instantiate Character class
Character currentCharacter = new Character(characterName, characterRace);       



boolean continuePlay;
 do {
   currentCharacter.printStats();
   System.out.println("What would you like to do now? Drinking Game Or Quit");
   String nextMove = scanIn.nextLine();
   if (nextMove.equalsIgnoreCase("Drinking Game"))
           {
           DrinkingGame currentDrinkingGame = new DrinkingGame(currentCharacter.maxDrinks);
           if (currentDrinkingGame.drink()) currentCharacter.addCoin(5);
           }
   continuePlay = (!nextMove.equalsIgnoreCase("Quit"));
 } while (continuePlay);

   }

   }