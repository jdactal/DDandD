//import statements go here

public class Ogre extends Monster
{
   //Monster data persists while the instance persists
   private int hp;
   private int mp;
   private String type = "Ogre";
   private String name = "Charles";
   
   //Constructor
   public Ogre(int health, int magic)
   {
      hp = health;
      mp = magic;
      this.name = generateName();
   }
   
   //Default Constructor
   public Ogre()
   {
      hp = 10;
      mp = 10;
      this.name = generateName();
   }   

   //overrides Monster.attack()
   //limits the number of times the Ogre can attack
   public int attack()
   {
      if (mp > 5) 
      {
         mp = mp - 5;
         return 5;
      } else {
         return 0;
      }
   }

   public String getName() 
   {
      return name;
   }

   private String generateName()
   {
      String[] names = { "Alexei", "hibivizxivazuak", "Clyde", "Fred", "Humphery McHuphery", "xX_n00bSl@yer_Xx", "Clyde" };
      int random = (int)((Math.random()*7)+1);
      if (random >= 0 && random <= 6) return names[random];
      else return "Charles"; //something wrong with the generator!
   }

}