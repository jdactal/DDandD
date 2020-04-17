//import statements go here

public class Monster
{
   //Monster data persists while the instance persists
   private int hp;
   private int str;
   private int def;
   private int mp;
   private String type = "Monster";
   public String monName2;
   //Constructor
   public Monster(int health, int strength, int defense, int magic)
   {
      hp = health;
      str = strength;
      def = defense;
      mp = magic;
      monName2 = nameChooser();
   }
   
   //Default Constructor
   public Monster()
   {
      hp = 10;
      str = 5;
      def = 0;
      mp = 10;
   }   

   public int attack(int str){
      mp = mp - str;
      return str;
   }

   public int defend(int attack){
      hp = hp - attack + def;
      if (hp < 0) 
      {  
         hp = 0;
      }
      return hp;
   }
   private String nameChooser(){
   String[] monName = {"Brian", "Twinkie", "Julia", "Humphery", "xX_n00bSl@ya_Xx"};
   int rand = (int)(Math.random()*5);
   rand = (Math.round(rand));
   return monName[rand];
   }
   public int getHealth(){
      return hp;
   }
}