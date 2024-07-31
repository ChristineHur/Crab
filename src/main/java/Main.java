
import java.util.*;

public class Main 
{
  public static void main(String[] args)
  {
////////////////////////////////
    Scanner scanner = new Scanner(System.in);
    System.out.println("You fool...");
    System.out.println("Have you awoken?");
    System.out.println("[Type anything and then enter to continue.]");
    String v = scanner.nextLine();
    System.out.println("Ah, yes. You're finally awake. What's your name?");
    System.out.println("[Enter your name]");
    v = scanner.nextLine();
    Player b = new Player(v);
    Game a = new Game(b);
    System.out.println("Now " + v + ". You've landed on an island, all alone with only a few things surrounding you. Most of those things are cards. Not very useful... Or are they? \nThere are a line of crabs coming to attack you from the west, so get ready and prepare for war. Maybe with some of those cards? Though your hands are quite small. I don't think you'd be able to hold more than five at a time. \nWhenever a crab attacks you, two more cards may or may not be in reach of you to grab. It's all up to what cards you have available to you at the time. As you beat more of the crabs, different types of cards may be available to you.\nIt all depends on the choices you make.\nGood luck. You'll need it.");
    System.out.println("[Type anything and then enter to continue.]");
    v = scanner.nextLine();
    System.out.println();
    a.play();

    
  }
}

