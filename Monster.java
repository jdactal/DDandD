//import statements go here

public class Monster
{
   //Monster data persists while the instance persists
   private int hp;
   private int mp;
   private String type = "Monster";
   
   //Constructor
   public Monster(int health, int magic)
   {
      hp = health;
      mp = magic;
   }
   
   //Default Constructor
   public Monster()
   {
      hp = 10;
      mp = 10;
   }   

   public int attack(){
      mp = mp - 5;
      return 5;
   }

   public int defend(int attack){
      hp = hp - attack;
      if (hp < 0) 
      {  
         hp = 0;
      }
      return hp;
   }
}