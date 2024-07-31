import java.util.*;
public class Player
  
{
  private String username;
  private int hp;
  private int strBon;
  private int accBon;
  private Deck deck;
  private boolean brace;

  public Player(String ign)
  {
    username = ign;
    hp = 100;
    deck = new Deck();
  }

public void takeDmg(int xhp){hp=hp-xhp;}
public void attack(){}
public void play(){}
public int getHp(){return hp;}
public int getStr(){return strBon;}
public int getAcc(){return accBon;}
public Deck getDeck() {return deck;}
Scanner scanner = new Scanner(System.in);


  public void endTurn()
  { 
    System.out.println("You ended your turn.\nEnemy hit you for " + Game.getCurrentEnemy().getAtk() + " damage. You will now draw 2 cards.\n\n▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n");
    if (brace == false)
    {
    takeDmg(Game.getCurrentEnemy().getAtk());
    }
    else{this.brace = false;}
    deck.draw();
    deck.draw();
  }

  public void enemyDefeated()
  {
    strBon = 0;
    accBon = 0;
    hp+=20;
    if (hp > 100){hp = 100;}
    deck.draw();
    deck.draw();
    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n\n");
  }
    
  public void myStats()
  {
    System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯\n" + username + "'s HP: " + hp +"\nStr boost: " + strBon + "     Acc boost: " + accBon + "\n🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧");
  }

  public void useCard(int input)
  {
    Card a = deck.getHand().get(input);
    System.out.println("You used the card: " + a.getName());
    deck.discard.add(deck.hand.get(input));
    deck.hand.remove(input);
    boolean hit = ((int) (Math.random() * 100) + 1) <= a.getAcc() + accBon;
    if (a.getName().equals("Whirlwind"))
    {
      boolean active = true;
      int test = 0;
      int help = 0;
      while (active)
      {
        help = ((int) (Math.random() * 100)) + 1;
        boolean hit2 = help <= a.getAcc() - test + accBon;
        if (hit2 == true)
        {
          Game.getCurrentEnemy().takeDmg(a.getStr() + this.strBon);
          System.out.println("WHOOSH!");
          test = test + 10;
        }
        else {active = false;}
      }
    }
    else if (a.getName().equals("Explosion"))
    {
      Game.getCurrentEnemy().takeDmg(hp);
      takeDmg(hp / 2);
      System.out.println("💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥💥");
    }
    else if (a.getName().equals("Heal"))
    {
      hp += 10;
      if (hp >= 100)
      {
        hp = 100;
      }
    }
    else if (a.getName().equals("Brace"))
    {
      brace = true;
    }
    else if (a.getName().equals("Cook"))
    {
      strBon+=a.getStrBon();
      Game.getCurrentEnemy().setAtk(Game.getCurrentEnemy().getAtk() + 5);
    }
    else if (a.getName().equals("Skim"))
    {
      deck.draw();
      deck.draw();
    }
    else if (a.getName().equals("Cripple"))
    {
      Game.getCurrentEnemy().setAtk(Game.getCurrentEnemy().getAtk() - 1);
    }
    else if (a.getName().equals("Draw Blood"))
    {
      hp = hp - 8;
      for (int i = 0; i < 4; i++)
        {
          deck.draw();
        }
    }
    else if (a.getName().equals("Final Gambit"))
    {
      if (hp < 10) 
      {Game.getCurrentEnemy().takeDmg(a.getStr() + this.strBon);}
      else
      {
        System.out.println("Maybe take a better look at your hp...");
      }
    }
      else if (hit && (a.getStr() != 0))
      {
        Game.getCurrentEnemy().takeDmg(a.getStr() + this.strBon);
      }
      else if (a.getStr() == 0){strBon+=a.getStrBon();accBon+=a.getAccBon();}
      else{System.out.println("Miss!");}
    }
}