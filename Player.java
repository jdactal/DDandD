public class Player 
{
   private String name; // Player name
   private int max_hp; // max health
   private int hp; // health points
   private int mp; // magic points
   private int attack; //attack strength with no weapons
   private int defend; //defend strength with no weapons
   private Weapon theWeapon;

   public Player(String playerName) 
   {
      name = playerName;
      hp = (int) (Math.random() * 21) + 40;
      max_hp = hp;
      mp = (int) (Math.random() * 21) + 10;
      attack = (int) (Math.random() * 11) + 5;
      defend = (int) (Math.random() * 11) + 5;
   }

   public void getStats() 
   {
      System.out.println();
      System.out.println(name.toUpperCase() + "'s STATS");
      System.out.println("Health Points: " + hp + " of max points " + max_hp);
      System.out.println("Magic Points: " + mp);
      int combinedAttack = attack + theWeapon.getAttackStrength();
      System.out.println("Attack Power: " + combinedAttack);
      int combinedDefend = defend + theWeapon.getDefendStrength();
      System.out.println("Defense Strength: " + combinedDefend);
      System.out.println("Weapon: " + theWeapon.getType());
      System.out.println(" ");
   }

   public String getName()
   {
      return name;
   }
   
   public int getMaxHealth()
   {
      return max_hp;
   }
   
   public int getHealth()
   {
      return hp;
   }
   
   public int getMagic()
   {
      return mp;
   }
   
   public Weapon getWeapon()
   {
      return theWeapon;
   }
   
   public void setWeapon(Weapon aWeapon) 
   {
      theWeapon = aWeapon;
   }

   public int attack() 
   {
      int damage = (int)(Math.random()*(attack+theWeapon.getAttackStrength())+1); 
      return damage;
   }

   public int defend(int hit)
   {
      int damage = hit - (int)(Math.random()*(defend+theWeapon.getDefendStrength())+1);
      if (damage <= 0) damage = 0;
      hp = hp - damage;
      if (hp <= 0) hp = 0;
      return hp;
   }
   
   public int heal(int healing, int cost) 
   {
      if (mp >= cost) 
      {
         hp = hp + healing;
         mp = mp - cost;
         return hp;
      } else return 0;
   }
   
   public int search(int cost)
   {
      if (mp >=cost)
      {
         mp = mp - cost;
      }
      //ToDo: Add find weapon
      //ToDo: Add find spell (+mp)
      //ToDo: Add find health potion (+hp)
      return 0; //found nothing!
   }
   }