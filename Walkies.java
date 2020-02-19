import java.util.Scanner;

public class Walkies
{
   private static Scanner keyboard;
   private static Player hero;
   private static Ogre ogre;

   public static void introduction()
   {
      System.out.println(" ");
      System.out.println(hero.getName() + ", at the bottom of the contract you signed when ");
      System.out.println("you became a member of the imperial guard is the phrase: ");
      System.out.println("  'And will perform other duties as assigned'");
      System.out.println(" ");
      System.out.println("Today's other duty is:  Taking the princess' dog for a walk! ");
      System.out.println("It is time to play... Walkies! ");
      System.out.println(" ");
      System.out.println(" ");
   }

   public static void runCaveScenario(int scene)
   {
      switch (scene)
      { 
         case 0:
            System.out.println(hero.getName() + " bravely runs away, and lives to play Walkies another day!");
            System.exit(0);
         case 1: 
            System.out.println(hero.getName() + ", you are walking the princess' dog on the beach ");
            System.out.println("when you see a cave at the base of a cliff.  An ogre jumps out of the ");
            System.out.println("cave and says: Hi! I'm "+ ogre.getName() + ". "); 
            System.out.println(" ");
            System.out.println(ogre.getName() + " grabs the dog and says 'Thanks for bringing lunch!'");
            System.out.println(" ");
            break;
         case 2:
            System.out.println(ogre.getName() + " says: 'Did you want to join me for lunch?'" );
            System.out.println(" ");
            break;
         case 3: 
            System.out.println(ogre.getName() + " says 'Suddenly, I'm not very hungry.' ");
            System.out.println("Then, " + ogre.getName() + " lets go of the dog. ");
            System.out.println(" ");
            break;
         case 4:
            System.out.println(ogre.getName() + " says 'That was not very friendly!'; then it returns to its cave. ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("You return to the castle. Your duty successfully completed, the Ogre banished, ");
            System.out.println("now you can go home to play Walkies! ");
            System.out.println(" ");
            System.exit(0);
         case 5:
            System.out.println(ogre.getName() + " eats the dog and lives happily ever after.  However, the princess ");
            System.out.println("makes sure " + hero.getName() + " gets a year of duty cleaning the dog park! ");
            System.out.println(" ");
            System.out.println("Better luck playing Walkies next time! ");
            System.exit(0);
         default:
            System.out.println("The dog looks up at you. With your sudden ability to read canine thoughts, ");
            System.out.println("you realize the dog is thinking: ");
            System.out.println("'I have got to get somebody else to take me walkies next time.'");
            System.out.println(" ");
      }
      int action = getAction();
      runNextScene(scene, action);
   }

   public static int getAction()
   {
      System.out.println("Your options are: ");
      System.out.println("Enter 1 for Attack with Magic Sword! (Cost: 5 MP)");
      System.out.println("Enter 2 for Defend with Magic Sword! (Cost: 2 MP)");
      System.out.println("Enter 3 for Search for Treasure! (Cost: 1 MP)");
      System.out.println("Enter 4 for Cast Healing Spell (Cost: 2 MP, Gain 7 HP)");
      System.out.println("Or Retreat! ");
      System.out.println();
      System.out.println("Your choice?");
      int choice = keyboard.nextInt();
      keyboard.nextLine();
      
      return choice;
   }
   
   public static void runNextScene(int priorScene, int action)
   {  
      if (priorScene < 0) priorScene = 2;
      switch(priorScene)
      {
         case 1: //grabby ogre
            if (action==2||action==4) runCaveScenario(-1); //non-sensical
            else if (action==1) //attack the ogre!
            {
               //get attack value
               int attack = hero.attack();
               System.out.println(hero.getName() + " attacks with a strength of " + attack);
               int defend = ogre.defend(attack); //uses defend method from Monster
               System.out.println(ogre.getName() + " defends, and is left with a strength of " + defend);
               System.out.println(" ");
               if (defend > 0) runCaveScenario(5); //ogre eats
               else runCaveScenario(3); //ogre drops dog
            }
            else runCaveScenario(5); //ogre eats
            break;
         case 2: //penitent ogre
            if (action==2||action==3||action==4) runCaveScenario(-1); //non-sensical
            else runCaveScenario(4); //ogre retreats
            break;
         default: 
            runCaveScenario(-1); //non-sensical
      }
   }
   
   public static void main(String[] args){
      keyboard = new Scanner(System.in);

      //Player name and initialization
      System.out.print("Enter the hero's name: ");
      String name = keyboard.nextLine();
      hero = new Player(name);
      Weapon knife = new Weapon(1, 1, "Pocket Knife");
      hero.setWeapon(knife);

      hero.getStats();
      
      //monster initialization
      ogre = new Ogre(10, 5);

      //Introduction
      introduction();
      
      //Cave Scenario
      runCaveScenario(1);
   }   