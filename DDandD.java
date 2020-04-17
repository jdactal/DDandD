import java.util.Scanner;

public class DDandD
{
   private static Scanner scan;
   private static Player hero1;
   private static Player hero2;
   private static Player hero3;
   private static Orc orc;
   private static Ogre ogre;
   private static int currentHero;
   private static int choice;
   private static int numofAttacks;
   
   public static void introduction()
   {
      System.out.println(" ");
      System.out.println(hero1.getName() + ", " + hero2.getName() + ", and " + hero3.getName() + " are walking through a dungeon...");
      System.out.println("They are going to find a treasure... ");
      System.out.println("Jesus, Jacob! This script is as thick as the dictionary! Can't we just get to the game already?");
      System.out.println("*whisper whisper* Fine, fine. The intro is important, I guess... Hang on, i'll do it...");
      System.out.println("Ahem! Moronic friends " + hero1.getName() + ", " + hero2.getName() + ", and " + hero3.getName());
      System.out.println("are going to raid a dungeon... However, there are spooky monsters that will likely brutally slaughter them (if they don't press attack every turn).");
      System.out.println("Wait... Podracers? JACOB! WHY ARE THERE PODRACERS IN THIS GAME??? *whisper whisper* Ok, I'm actually down with that. That sounds lit.");
      System.out.println("Anyway, enough cringey intros. Time for Dungeons, Dungeons and More Dungeons! By the way, if you find any bugs, email me at EvilOverlord3@gmail.com, and I may squash them.");
      System.out.println(" ");
      System.out.println(" ");
      System.out.println(" ");
      System.out.println(" ");
   }
   public static String changeHeroFunction(){
      switch(currentHero){
         case 1:
            currentHero = 2; 
            return hero1.getName();
         case 2:
            currentHero = 3;
            return hero2.getName();
         case 3:
            currentHero = 4;
            return hero3.getName();
         case 4:
            currentHero = 1;
            return hero1.getName();
      }
      return null;
   }
   public static void runDungeonScenario(int scene)
   {
      switch (scene)
      { 
         case 0: //ogre escape attempt
            System.out.println(ogre.getName() + " runs away, slips on a rock, falls and dies. Haha, coward!");
            System.exit(0);
         case 1: //aggressive ogre
            System.out.println("The ogre " + ogre.getName() + " is laughing at " + getHeroName(currentHero) + " like a creepy uncle.");
            System.out.println(" ");
            break;
         case 2: //passive ogre
            System.out.println(ogre.getName() + " wrings his hands nervously...");
            System.out.println(" ");
            break;
         case 3: //ogre defeat
            System.out.println(ogre.getName() + " dies in a spectacular, bloody explosion.");
            break;
         case 4: //good end
            System.out.println("You save the world or something. The king gives you a handsome grant and with it ");
            System.out.println("you buy a mansion and podracer.");
            System.out.println("Huh. There really was a podracer in this story. Who knew?");
            System.out.println("You attacked a total of " + numofAttacks + " times, netting you a score of " + numofAttacks * 3 + ".");
            System.exit(0);
         case 5://bad end
            System.out.println("All three heroes suddenly burst into flames and burn to ashes");
            System.out.println("Try not to die next time, idiot");
            System.exit(0);
         case 6: //game breaks
            System.out.println("Whelp, you broke the game, somehow. Congradulations!");
            System.out.println("I'm going to reset the game. Don't wory; My evil minions are working to fix it.");
            System.out.println("If the problem isn't updated, tell me at EvilOverlord3@gmail.com");
            System.exit(0);
         case 7: //ambient?
            System.out.println("I can't wait for " + getHeroName(currentHero) + " to die!");
            System.out.println(" ");
         case 8:
            System.out.println("A fat orc stands in your way");
            System.out.println("It wants to fight");
            break;
      }
      int action = getAction(getHeroName(currentHero));
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
      System.out.println("Enter 5 to Retreat!");
      System.out.println();
      System.out.println("Your choice?");
      Scanner scanner = new Scanner(System.in);
      int choice = scanner.nextInt();
      return choice;
      
   }
   
   public static void runNextScene(int priorScene, int action)
   {  
      if (priorScene < 0 || priorScene > 2){
         priorScene = 2;
      }
      switch(priorScene)
      {
         case 1: //grabby ogre
            if (action==2||action==4){
               runDungeonScenario(7); //not important
            }
            else if (action==1) //attack!
            {
               //get attack value
               int attack = getHero(currentHero).attack();
               System.out.println(currentHero + " attacks with a strength of " + attack);
               int defend = ogre.defend(attack); //uses defend method from Monster
               System.out.println(ogre.getName() + " defends, and is left with " + ogre.getHealth() + " health.");
               System.out.println(" ");
               if (ogre.getHealth() > 0){
                  runDungeonScenario(7); //not important
               }else{
                  runDungeonScenario(3); //win
                  System.out.println(" ");
                  runDungeonScenario(4); //good end
               }
               if(action==5){
                  runDungeonScenario(5); //heroes die
               }
            }
            else runDungeonScenario(7); //not important
            break;
            
         case 2://orc fight
            if(action==2||action==4){
               runDungeonScenario(7);
            }
            else if(action==1){
               int attack = getHero(currentHero).attack();
               System.out.println(currentHero + " attacks with a strength of " + attack);
               int defend = orc.defend(attack);//orcs should attack with their health, not MP
               int rand2 = (int)(Math.random()*3)+1;
               if(rand2 == 1){
                  System.out.println("The Orc yeets itself at " + currentHero + " for a total of " + orc.attack() + " damage! It also hurts itself a little.");
                  break;
               }
               else{
                  System.out.println("The Orc defends! It's left with " + orc.getHealth() + " health!");
                  break;
               }
               
            }
            /*
         case 4: 
            runDungeonScenario(6); //game break
            System.exit(0);
            */
      }
   }
   public static String getHeroName(int currentHero){
      switch(currentHero){
         case 1:
            return hero1.getName();
         case 2:
            return hero2.getName();
         case 3:
            return hero3.getName();
         case 4:
            return hero1.getName();
      }
      return null;
   }
   public static Player getHero(int currentHero){
      switch(currentHero){
         case 1:
            return hero1;
         case 2:
            return hero2;
         case 3:
            return hero3;
      }
      return null;
   }

   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      currentHero = 1;
      String name = " ";
      Weapon knife = new Weapon(1, 1, "Stabby Thingy", 1);
      int defend = 10;
      
      //Player name and initialization
      System.out.print("Enter the first moron's name: ");
      name = scan.nextLine();
      hero1 = new Player(name);
      hero1.setWeapon(knife);
      
      System.out.print("Enter the second moron's name: ");
      name = scan.nextLine();
      hero2 = new Player(name);
      hero2.setWeapon(knife);
      
      System.out.print("Enter the third moron's name: ");
      name = scan.nextLine();
      hero3 = new Player(name);
      hero3.setWeapon(knife);
      
      hero1.getStats();
      hero2.getStats();
      hero3.getStats();
      
      //monster initialization
      ogre = new Ogre(10, 5);
      orc = new Orc(25, 0);
      
      //Introduction
      System.out.println("Want to see the intro, moron? (y/n)");
      String response = scan.nextLine();
      if(response.equals("y")){
         introduction();
      }
      else{
         System.out.println("Neither do I! Glad we're on the same page.");
      }
      //Cave(Dungeon) Scenario
      //ogre fight
      int scene = 1;
      numofAttacks = 0;
      while(true){
         for(int i = 1; i <= 3; i++){
            runDungeonScenario(1);
            numofAttacks++;
            if(ogre.getHealth() > 0){
               changeHeroFunction();
               runDungeonScenario(1);
               numofAttacks++;
            }
            else if(ogre.getHealth() <= 0){
               runDungeonScenario(8);
               numofAttacks++;
               if(orc.getHealth() > 0){
                  changeHeroFunction();
                  runDungeonScenario(8);
                  numofAttacks++;
               }
               else if(orc.getHealth() <= 0){
                  runDungeonScenario(3);
                  System.out.println(" ");
                  runDungeonScenario(4);
               }
            }
         } 
      }

   }
}