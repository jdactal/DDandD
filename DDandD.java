import java.util.Scanner;

public class DDandD
{
   private static Scanner scan;
   private static Player hero1;
   private static Player hero2;
   private static Player hero3;
   private static Orc orc;
   private static Ogre ogre;

   public static void introduction()
   {
      System.out.println(" ");
      System.out.println(hero1.getName() + ", " + hero2.getName() + ", and " + hero3.getName() + " are walking through a dungeon...");
      System.out.println("They are going to find a treasure... ");
      System.out.println("Jesus, Jacob! This script is as thick as the dictionary! Can't we just get to the game already?");
      System.out.println("*whisper whisper* Fine, fine. The intro is important, I guess... Hang on, i'll do it...");
      System.out.println("Ahem! Moronic friends " + hero1.getName() + ", " + hero2.getName() + ", and " + hero3.getName());
      System.out.println("are going to raid a dungeon... Blah Blah Blah Princess Blah Blah Blah Treasure Blah Blah Blah Dragon.");
      System.out.println("Wait... Podracers? JACOB! WHY ARE THERE PODRACERS IN THIS GAME??? *whisper whisper* Ok, I'm actually down with that. That sounds lit.");
      System.out.println("Anyway, enough cringey intros. Time for Dungeons, Dungeons and More Dungeons!");
   }
   public static String changeHeroFunction(){
      switch(currentHero){
         case 1:
            int currentHero = hero1.getName(); 
            return currentHero;
         case 2:
            int currentHero = hero2.getName();
            return currentHero;
         case 3:
            int currentHero = hero3.getName();
            return currentHero;
         default:
            int currentHero = hero1.getName();
            return currentHero;
         }
   }
   public static void runDungeonScenario(int scene)
   {
      switch (scene)
      { 
         case 0: //escape attempt
            System.out.println(currentHero.getName() + " runs away, slips on a rock, falls and dies. Haha, coward!");
            System.exit(0);
         case 1: //aggressive ogre
            System.out.println("The ogre " + ogre.getName() + " is laughing at " + currentHero.getName() + " like a creepy old man.");
            System.out.println(" ");
            break;
         case 2: //passive ogre
            System.out.println(ogre.getName() + "wrings his hands nervously...");
            System.out.println(" ");
            break;
         case 3: //ogre defeat
            System.out.println(ogre.getName() + " dies in a spectacular, bloody explosion.");
            break;
         case 4: //good end
            System.out.println("You save the world or something. The king gives you a hansome grant and with it ");
            System.out.println("you buy a mansion and podracer.");
            System.out.println("Huh. There really was a podracer in this story. Who knew?");
            System.exit(0);
         case 5://bad end
            System.out.println("All three heroes suddenly burst into flames and burn to ashes");
            System.out.println("Try not to die next time, idiot");
            System.exit(0);
         case 6: //game breaks
            System.out.println("Whelp, you broke the game, somehow. Congradulations!");
            System.out.println("I'm going to reset the game. Don't wory; My evil minions are working to fix it.");
            System.out.println("If the problem isn't updated, tell me at ");
            System.exit(0);
         default: //ambient?
         System.out.println("I can't wait for " + currentHero.getName() + " to die!");
         System.out.println(" ");
      }
      int action = getAction();
      runNextScene(scene, action);
   }

   public static int getAction(String currentHero)
   {
      System.out.println("Current hero is: " + currentHero);
      System.out.println("Your options are: ");
      System.out.println("Enter 1 for Attack with Stabby Thingy! (Cost: 5 MP)");
      System.out.println("Enter 2 for Defend with Stabby Thingy! (Cost: 2 MP)");
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
      if (priorScene < 0){
        priorScene = 2;
        }
      switch(priorScene)
      {
         case 1: //grabby ogre
            if (action==2||action==4){
               runDungeonScenario(1); //non-sensical
            }
            else if (action==1) //attack the ogre!
            {
               //get attack value
               int attack = currentHero.attack();
               System.out.println(currentHero.getName() + " attacks with a strength of " + attack);
               int defend = ogre.defend(attack); //uses defend method from Monster
               System.out.println(ogre.getName() + " defends, and is left with a strength of " + defend);
               System.out.println(" ");
               if (defend > 0){
                  runDungeonScenario(1);
               }else{
                  runDungeonScenario(3); //ogre drops dog
                  System.out.println(" ");
                  runDungeonScenario(4);
               }
            }
            else runDungeonScenario(0); //ogre eats
            break;
         case 2: //penitent ogre
            if (action==2||action==3||action==4)
            {
               runDungeonScenario(-1); //non-sensical
            }else{
               runDungeonScenario(4); //ogre retreats
            }
            break;
         default: 
            runDungeonScenario(-1); //non-sensical
      }
   }
   
   
   public static void main(String[] args){
      keyboard = new Scanner(System.in);
      currentHero = 1;
         
      //Player name and initialization
      System.out.print("Enter the first moron's name: ");
      String name = keyboard.nextLine();
      hero1 = new Player(name);
      Weapon knife = new Weapon(1, 1, "Stabby Thingy", 1);
      hero.setWeapon(knife);
      
      System.out.print("Enter the second moron's name: ");
      String name = keyboard.nextLine();
      hero2 = new Player(name);
      Weapon knife = new Weapon(1, 1, "Stabby Thingy", 1);
      hero.setWeapon(knife);
      
      System.out.print("Enter the third moron's name: ");
      String name = keyboard.nextLine();
      hero3 = new Player(name);
      Weapon knife = new Weapon(1, 1, "Stabby Thingy", 1);
      hero.setWeapon(knife);
      
      hero1.getStats();
      hero2.getStats();
      hero3.getStats();
      
      //monster initialization
      ogre = new Ogre(10, 5);
      orc = new Orc(25, 0);
      
      //Introduction
      System.out.println("Want to see the intro, moron? (y/n)");
      String response = scan.nextLine();
      if(response == "y"){
         introduction();
      }
      else{
         System.out.println("Neither do I! Glad we're on the same page.");
      }
      //Cave Scenario
      runCaveScenario(1);
   } 
}