import java.util.Random;

public class Character {
   String name;
   String race;
   int coins;
   int danceSkill;
   int maxDrinks;
   int gameSkill;

public Character(String a, String b){
   name = a;
   race = b;
// Give character 2-30 coins to start with
         Random rand = new Random();
         int startCoins = rand.nextInt(10) + 20;
         coins = startCoins;
//Assign a dance skill number based on race    
         int startDanceSkill;
         if (race.equalsIgnoreCase("Elf")){startDanceSkill = 80;}
         else if (race.equalsIgnoreCase("Dwarf")){startDanceSkill = 50;}
         else if (race.equalsIgnoreCase("Human")){startDanceSkill = 60;}
         else if (race.equalsIgnoreCase("Wizard")){startDanceSkill = 60;}
         else if (race.equalsIgnoreCase("Hobbit")){startDanceSkill = 85;}
         else {startDanceSkill = 0;}   
   danceSkill = startDanceSkill;   
 // Give character max drink number
         Random randDrink = new Random();
         int startMaxDrinks = randDrink.nextInt(10) + 10;
         maxDrinks = startMaxDrinks;
 }

public void printStats() {
System.out.println("Name: " + name);
System.out.println("Race: " + race);
System.out.println("Coins: " + coins);
// System.out.println("Dance Skills: " + danceSkill);
System.out.println("Max Drinks: " + maxDrinks);
}

public void addCoin(int add) {
coins = coins + add;
}

}
