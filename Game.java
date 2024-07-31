import java.util.*;
public class Game
{
  private static Enemy currentEnemy;
  private Player player;

  Enemy crab1 = new Enemy (25, 8, "Blue Crab");
  Enemy crab2 = new Enemy (40, 10, "Green Crab");
  Enemy crab3 = new Enemy (70, 5, "Mud Crab");
  Enemy crab4 = new Enemy (40, 15, "Coconut Crab");
  Enemy crab6 = new Enemy (1, 10, "Ghost Crab");
  Enemy crab5 = new Enemy (150, 10, "[BOSS] Crabulon");
  Enemy[] enemies = new Enemy[]{crab1, crab2, crab3, crab4, crab6, crab5};

  
  public Game(Player a)
  {
    currentEnemy = enemies[0];
    player = a;
  }

  public static Enemy getCurrentEnemy() {return currentEnemy;}

  public void play()
{
  Scanner scanner = new Scanner(System.in);
  int x = 0;
  while ((x<enemies.length) && (player.getHp()>0))
  {
      if (enemies[x].getHp()!=0)
        {
          currentEnemy = enemies[x];
          enemies[x].arrival();
          player.myStats();
          System.out.println();
          player.getDeck().printDeck();
          System.out.println("========================\nType the number of one of the cards presented. To end turn, type any other number.\n");

          int input = scanner.nextInt();
          if (input<player.getDeck().hand.size())
          {
            player.useCard(input);
          }
          else {player.endTurn();} 
        }
    else
      {
        if (x < enemies.length - 1){
        System.out.println("【Congrats! You defeated the enemy!】");
        int choice1 = (int)(Math.random()*player.getDeck().library.size());
        int choice2 = (int)(Math.random()*player.getDeck().library.size());
        int choice3 = (int)(Math.random()*player.getDeck().library.size());
        while (choice1==choice2 || choice2==choice3 ||choice1==choice3)
          {
            if (choice1==choice2 || choice1==choice3)
            {
              choice1 = (int)(Math.random()*player.getDeck().library.size());
            }
            else{choice2 = (int)(Math.random()*player.getDeck().library.size());}
          }
        System.out.println("As you exit your battle, you feel the buffs you've gained slowly leave your body as you rest.");
        System.out.println("The only way to get these back is to enter battle again.");
        System.out.println();
        System.out.println("As you get back up, you notice a few more cards in your reach. Why don't you try to get one?");
        player.getDeck().library.get(choice1).printCard();
        player.getDeck().library.get(choice2).printCard();
        player.getDeck().library.get(choice3).printCard();
        System.out.println("Enter a number from 1-3:");
        
        int lol = scanner.nextInt();
        if (lol==1)
        {
          Card l = player.getDeck().library.get(choice1);
          player.getDeck().deck.add(l);
        }
        else if (lol==2)
        {
          player.getDeck().deck.add(player.getDeck().library.get(choice2));
        }
        else if (lol==3)
        {
          player.getDeck().deck.add(player.getDeck().library.get(choice3));
        }
        else 
        {
          System.out.println("You have not chosen one of the cards nearest to you. So in your ambition, you reach too far and miss, leaving you with nothing.");
        }
      player.enemyDefeated();
      }
      x++;
    }
  } //while loop ends
  if (x >= enemies.length)
  {
    while (true) {
    System.out.println("🎆🎆🎆You've won against all of the crabs! Congratuations.🎆🎆🎆");
    }
  }
  else
  {
    System.out.println("🦀🦀You've died, unprepared and weak against the line of crabs.🦀🦀");
  }
}//play() ends
  
}