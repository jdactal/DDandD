

public class Orc extends Monster {
private int hp;
private int atk;
private int mp;
private String type = "Orc";
private String weapon = "dagger";
private boolean weaponEquip = true;

public Orc(int health, int magic){
   hp = health;
   mp = magic;
   
   weapon = "dagger";
}
public Ogre()
   {
      hp = 25;
      mp = 0;
      this.name = generateName();
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
public int attackWeapon(){
   if(weaponEquip == true){
   int damage = 
   return damage;
   }
}

}