
import java.util.Scanner;

public class Game {

   public String characterName;
   public String characterRace;

   public void playGame() {
      startGame();
// Instantiate Character class
      Character currentCharacter = new Character(characterName, characterRace);
      boolean continuePlay;
      do {
         currentCharacter.printStats();
         System.out.println("What would you like to do now? Drinking Game Or Quit");
         Scanner scanInPlay = new Scanner(System.in);
         String nextMove = scanInPlay.nextLine();
         if (nextMove.equalsIgnoreCase("Drinking Game")) {
            DrinkingGame currentDrinkingGame = new DrinkingGame(currentCharacter.maxDrinks);
            if (currentDrinkingGame.drink()) {
               currentCharacter.addCoin(5);
            }
         }
         continuePlay = (!nextMove.equalsIgnoreCase("Quit"));
      } while (continuePlay);

   }

   public void startGame() {
      System.out.println("Welcome, traveler, to the Green Dragon Inn! What's your name?");
      Scanner scanIn = new Scanner(System.in);
      characterName = scanIn.nextLine();
      boolean invalidRace;
      System.out.printf("Come on in, %s. ", characterName);
// Ask for race - only allow elf, human, hobbit, wizard, or dwarf
      do {
         System.out.printf("Pardon me for asking, but what race are you? %n", characterName);
         characterRace = scanIn.nextLine();
         invalidRace = (!characterRace.equalsIgnoreCase("elf") && !characterRace.equalsIgnoreCase("human") && !characterRace.equalsIgnoreCase("hobbit") && !characterRace.equalsIgnoreCase("wizard") && !characterRace.equalsIgnoreCase("dwarf"));
         if (invalidRace) {
            System.out.printf("Never heard of that. ");
         } else {

            System.out.printf("'Tis a windy night out! Step on in by the fireplace, %s. We're always happy to welcome a friendly %s to our company!%n", characterName, characterRace);
         }
      } while (invalidRace);
   }

}
