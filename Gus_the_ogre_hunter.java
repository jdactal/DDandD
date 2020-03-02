import java.util.Scanner;

public class Gus_the_ogre_hunter {
   private static Scanner scan;
   private static Player Gus;
   private static Orc orc;
   
   public static void introduction() {
   System.out.println("Your name is Gus, the revered Orc Hunter, a brave warrior who, well, hunts orcs. Duh.");
   System.out.println("In reality, however, you are a complete coward.");
   System.out.println("However, your son was kiddnapped by orcs, so it's time to pick up your trusty broadsword...");
   System.out.println("And get him back!");
   System.out.println("...");
   System.out.println("After you conquer your fear of orcs...");
   System.out.println(" ");
   System.out.println(" ");
   }
   public static void runGusOrcBattle(int scene){
      switch(scene){
         case 0: // gus runs away
            System.out.println("Gus runs away, screeching like a banshee. The orcs and Gus's son roll their eyes in unison...");
            System.exit(0);
         case 1: // gus gets to the camp
            System.out.println("Gus readies his sword to attack!");
            break;
         case 2: // Gus falls and 50% dies, 50% lives
            System.out.println("Gus slips! He... ");
            int potato = (int)(Math.random());
            potato = (math.round(potato));
            if(potato == 0){
               System.out.print("Survives the fall!");
               break;
            }
            if(potato == 1){
            System.out.println("Falls and dies! Try grabbing onto somethng next time!");
            System.exit(0);
            }
         case 3: // gus defends
            System.out.println("Gus primes his will to defend!");
            break;
         case 4: //gus casts heal
            System.out.println("Gus casts Heal!");
            System.out.println("Gus regains " + 7 + " hp and uses " + 2 + " mp!");
            System.out.println("Now you have " + hp + " hp and " + mp + " mp!");
            break;
         case 5: // gus saves his kid
            System.out.println("Your son saved and the orcs defeated, you return to your hut in the woods.");
            System.out.println("Congradulatons! You didn't die!");
            System.exit(0);
         default:
            System.out.println("Gus and the Ogres are having a staredown...");
      
      int action = getAction();
      runNextScene(scene, action);
      }
      public static int getAction(){
      System.out.println("Your options are: ");
      System.out.println("Enter 1 to Attack with sword! (Cost: 5 MP)");
      System.out.println("Enter 2 to Defend with sword! (Cost: 2 MP)");
      System.out.println("Enter 3 to Cast Healing Spell (Cost: 2 MP, Gain 7 HP)");
      System.out.println("Or 4 to retreat! ");
      System.out.println();
      System.out.println("Your choice?");
      int choice = scan.nextInt();
      scan.nextLine();
      
      return choice;

   }
      public static void runNextScene(int priorScene, int action){  
      if (priorScene < 0) priorScene = 2;
      switch(priorScene){
         case 1:
            if (action==1){
               runGusOrcBattle(1);
               //get attack value
               int attack = Gus.attack();
               System.out.println("Gus attacks with a strength of " + attack);
               int defend = orc.defend(attack); //uses defend method from Monster
               System.out.println("The orc defends, and is left with a strength of " + defend);
               System.out.println(" ");
            }
            if(action==2){
               runGusOrcBattle(3);
               hp = hp + 7;
               mp = mp - 2;
               
            }
            runGusOrcBattle(2);
            break;
            
            default: 
            runCaveScenario(-1); //non-sensical
      }
   }

}
}