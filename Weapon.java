//import statements go here

public class Weapon
{
   //Weapon data persists while the instance persists
   private String type;
   private int attack;
   private int defend;
   
   //Constructor
   public Weapon(int attackStrength, int defendStrength, String descriptor)
   {
      type = descriptor;
      attack = attackStrength;
      defend = defendStrength;
   }
   
   //Default Constructor
   public Weapon()
   {
      type = "dagger";
      attack = 1;
      defend = 1;
   }
   
   public int getAttackStrength()
   {
      return attack;
   }

   public int getDefendStrength()
   {
      return defend;
   }
   
   public String getType()
   {
      return type;
   }
}