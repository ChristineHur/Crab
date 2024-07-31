import java.util.*;

public class Card
{
  private int str;
  private int acc;
  private int strBon;
  private int accBon;
  private String name;
  private String desc;
  

  public Card(String nameVal)
  {
    str = 0;
    acc = 0;
    name = nameVal;
    desc = "";
    
    if (name.equals("Slash")){acc = 80; str=8; desc="Use scissors to go for the crab's eyes. ✂️";}
    if (name.equals("Power")){acc = 50; str = 12; desc="Launch a heavy, inaccurate blow right to the crab's face. 👊";}
    if (name.equals("Stab")){acc = 100; str=5;desc="Free crab lobotomy. 🪡";}
    if (name.equals("Precision")){accBon = 10;desc="Open your eyes. 👀";}
    if (name.equals("Empower")){strBon=2;desc="Feel the rage run through your blood. 😡";}
    if (name.equals("Whirlwind")){acc=75;str=2;desc="Do damage continuously until it misses. Accuracy decreases per hit. 🌪";}
    if (name.equals("Heal")){acc=100; desc = "Heal for 10. 🩹";}
    if (name.equals("Explosion")){acc=100;desc="Sacrifice half your hp to do the double that amount to the enemy 💥";}
    if (name.equals("Prepare")){strBon=1; accBon = 5;desc="Sharpen your knife. 🔪";}
    if (name.equals("Cook")){strBon = 5; desc="Enemy takes more damage and deals more damage. 🍳";}
    if (name.equals("Skim")){acc=100; desc = "Draw 2 cards. 🃏🃏";}
    if (name.equals("Brace")) {acc=100; desc = "Avoid taking your next hit of damage. 🛡";}
    if (name.equals("Final Gambit")) {str = 30; acc = 100; desc = "If your health is less than 10, you do 30 damage. 🎰";}
    if (name.equals("Cripple")) {str = 0; acc = 100; desc = "Weaken your enemy's attack. 🦯";}
    if (name.equals("Draw Blood")) {str = 0; acc = 100; desc = "Sacrifice 8 hp to draw 4 cards. 🩸";}
    else{}
    
  }

  public String getName(){return name;}
  public int getAcc(){return acc;}
  public int getStr(){return str;}
public int getAccBon(){return accBon;}
  public int getStrBon(){return strBon;}

  
  public void printCard()
  {
    if (str!=0 && acc!=0)
    {
      System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯\nName: " + name +"\nDamage: " + str + "\nAcc: " +acc + "\n" + desc + "\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯\n");
    }
    else
    {
      System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯\nName: " + name + "\nStrength boost: " + strBon + "\nAccuracy boost: " + accBon + "\n" + desc + "\n⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
    }
  }
}