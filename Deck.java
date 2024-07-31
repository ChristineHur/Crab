import java.util.*;
public class Deck
{
  public ArrayList<Card> hand;
  public ArrayList<Card> discard;
  public ArrayList<Card> deck;
  public ArrayList<Card> library;

  public Deck()
  {
    hand = new ArrayList<Card>();
    library = new ArrayList<Card>();
    deck = new ArrayList<Card>();
    discard = new ArrayList<Card>();
    Card a = new Card("Stab");    
    Card b = new Card("Slash");
    Card c = new Card("Whirlwind");
    Card d = new Card("Empower");
    Card e = new Card("Heal");
    Card f = new Card("Prepare");
    Card g = new Card("Precision");
    Card h = new Card("Explosion");
    Card i = new Card("Cook");
    Card j = new Card("Skim");
    Card k = new Card("Power");
    Card l = new Card("Brace");
    Card m = new Card("Cripple");
    Card n = new Card("Draw Blood");
    Card o = new Card("Final Gambit");
    hand.add(a);
    hand.add(a);
    hand.add(a);
    hand.add(b);
    
    ////////////// deck
    deck.add(c);
    deck.add(b);
    deck.add(d);
    
    ////////////// library
    library.add(a);
    library.add(b);
    library.add(c);
    library.add(d);
    library.add(e);
    library.add(f);
    library.add(g);
    library.add(h);
    library.add(i);
    library.add(j);
    library.add(k);
    library.add(l);
    library.add(m);
    library.add(n);
    library.add(o);
  }

  public ArrayList<Card> getHand(){return hand;}
  public ArrayList<Card> getDeck(){return deck;}
  public ArrayList<Card> getLibrary(){return library;}


  public Card getRandomCard()
  {
    int a = library.size();
    int b = (int) (Math.random() * a);
    return library.get(b);
  }
  
    public void draw() 
  {
    if (deck.size() < 1)
    {
      shuffle();
      draw();
    }
    else if (hand.size() >= 5){}
    else
    {
      hand.add(deck.get(0));
      deck.remove(0);
    }
  }
  public void shuffle() 
  {
    int i = 0;
    Card a = null;
    while (discard.size() > 0)
    {
      i = (int)(Math.random() * discard.size());
      a = discard.get(i);
      deck.add(a);
      discard.remove(i);
    }
  }

  public void printDeck()
  {
    for (int x = 0; x<hand.size(); x++)
      {
        System.out.print(x+": \n");
        hand.get(x).printCard();
      }
  }

  public void realPrintDeck() //testing purposes
  {
    for (int x = 0; x < deck.size(); x++)
      {
        System.out.print(x+": ");
        deck.get(x).printCard();
      }
  }

}