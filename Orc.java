

public class Orc extends Monster {
   private int hp;
   private int atk;
   private int mp;
   private String type = "Orc";
   private boolean weaponEquip = true;

   public Orc(int health, int magic){
      hp = health;
      mp = magic;
   }
   public Orc()
   {
      hp = 25;
      mp = 0;
   }   

   public int attack()
   {
      if (hp > 5) 
      {
         hp = hp - 5;
         return 5;
      } else {
         return 0;
      }
   }
}