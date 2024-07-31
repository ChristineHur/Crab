import java.util.*;

public class Enemy
{
  private int hp;
  private int atk;
  private String name;

  public Enemy (int ehpVal, int eatkVal, String enameVal)
  {
    hp=ehpVal;
    atk=eatkVal;
    name=enameVal;
    }
public String getName(){return name;}
public int getHp(){return hp;}
public int getAtk(){return atk;}
public void setAtk(int a) {atk = a;}
public void takeDmg(int xhp)
  {
    hp=hp-xhp;
    if (hp<=0){hp=0;}
  }

  public void arrival()
  {
    System.out.println("🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧🟧\n🦀 "+name +" stands menacingly in front of you. 🦀\nHp: "+hp+ "     Atk: " +atk);
  }
}