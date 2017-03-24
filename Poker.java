/***********
This is a simple card game.  The goal is to get
the best poker hand you can.  You can click a card
to throw it away and replace it with a new card.
You can stop any time you wish.  You LOSE if you
draw a card and it is EXACTLY THE SAME as one that
is already showing.

Watch the movies above to see two example games.
In the first film, the player changes cards until
they have a flush - a good result.  In the second
film, they are trying for a full-house.  But the 
9 of diamonds comes up as a duplicate, so they lose.

To run the program, you need to download and unpack
this archive - it contains three Java classes and 
pictures of all the 52 cards in a deck.

Try to do the following exercises:

(1) When cardA is chosen (clicked), a new card appears.
Use the following command to check whether the new cardA
matches cardB:

   if (cardA.code.equals(cardB.code))
   { ... loser ... }

Test this by running the program and clicking cardA lots
of times until it matches one of the other cards.

(2) Improve #1 so that it checks cardA agains ALL the 
other 4 cards.

(3) Add a check like this for each of the 5 cards.
Test it carefully and thoroughly.

(4) A PAIR occurs if there are 2 cards of the same rank,
but different suits. e.g. the 9 of diamonds and 9 of spades.
Write a method that checks for a PAIR in the 5 cards.
It should examine all 5 cards and return true or false.

(5) You will have noticed that all the checking above
requires lots of code, because the 5 cards have "names".
This would become a lot simpler if the 5 cards were in
an ARRAY, like this:

    Card[] cards = new Card[5];
    
If you do this, the whole program must be REFACTORED -
that means changing ALL the commands to work correctly
with this new idea.  But you need to do this anyway -
the names cardA, cardB, cardC, cardD, and cardE must
disappear.   

=========================================================

Now you are ready to do some more complicated things.

(6) Write a method that checks ALL 5 cards to check for
exact duplicates - e.g. a losing hand.  It returs true
if the hand is legal (no duplicates) but returns false 
if the hand is not legal.  Now change the original program
so that it just calls  checkLegal()  each time a card 
is changed.  This makes things a lot simpler.

(7) Write a method to check for a FLUSH.  This means all the
suits are the same - that is, the FIRST LETTER of each code.

(8) Write a method to decide whether a hand contains 2 pairs.
That means 2 different pairs, e.g.  c7 d7 hk dj sj.
It returns true if there are 2 pairs, false otherwise.

(9) Write a method to check for 3 of a kind.

(10) Write a method for 4 of a kind.

(11) Write a method to check for a straight.  This is tricky,
as the ranks must go in order (5,6,7,8,9), but the ranks of 
Jack, Queen, King, and Ace don't follow a simple order.

(12) Write a method to SCORE a hand.  The scoring for poker
goes like this:

     0 - no pairs
     1 - a pair
     2 - 2 pairs
     3 - 3 of a kind
     4 - straight
     5 - flush
     6 - full house (3 of a kind plus another pair)
     7 - 4 of a kind
     8 - straight flush (a straight AND a flush)
     
(13) Lucky 13
If two hands have the same rank, the tie is broken by
comparing the highest card, then the next highest, etc.
But in a pair, the pair rankings are compared first.
In a full house, the 3-of-a-kind ranks are compared,
and then the pair ranks.  If two players have a straight
and the same highest card, it's a draw.  Same for a flush -
there is no suit that out-ranks another.

(14) Two-player-game

Make a second hand, below the first.  The players can take
turns changing cards, until they both "chicken out".  Or you
could allow only 5 changes each.  At the end, compare the 
2 hands to see who wins.  Be sure to RE-USE the methods
you wrote above.

(15) No-cheating, more realistic
In this version, don't allow duplicate cards to be selected
at random.  Instead, each time a card is chosen, its code
in the Deck array is changed to "xx".  That means it has 
already been taken.  Then when choosing a card at random,
if and "xx" is chosen, choose another random number until 
a real card is selected.     

***/

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Poker extends EasyApp
{
   public static void main(String[] args)
   {  
      new Poker();
   }
   
   String[] deck = 
   {
    "sa","s2","s3","s4","s5","s6","s7","s8","s9","st","sj","sq","sk",
    "ha","h2","h3","h4","h5","h6","h7","h8","h9","ht","hj","hq","hk",
    "da","d2","d3","d4","d5","d6","d7","d8","d9","dt","dj","dq","dk",
    "ca","c2","c3","c4","c5","c6","c7","c8","c9","ct","cj","cq","ck" 
   };

   Card cardE = new Card(deck[0],340,50,72,97,this);
   Card cardD = new Card(deck[10],260,50,72,97,this);
   Card cardC = new Card(deck[20],180,50,72,97,this);
   Card cardB = new Card(deck[30],100,50,72,97,this);
   Card cardA = new Card(deck[40],20,50,72,97,this);
   
   Button bDeal = addButton("Deal",10,160,50,30,this);
   
   public Poker()
   { 
      setTitle("Sample");
      setBounds(40,40,450,200);
     
   }

   public void deal()
   { 
     this.remove(cardE);
     this.remove(cardD);
     this.remove(cardC);
     this.remove(cardB);
     this.remove(cardA);
     cardE = new Card(deck[random(0,51)],340,50,72,97,this);
     cardD = new Card(deck[random(0,51)],260,50,72,97,this);
     cardC = new Card(deck[random(0,51)],180,50,72,97,this);
     cardB = new Card(deck[random(0,51)],100,50,72,97,this);
     cardA = new Card(deck[random(0,51)],20,50,72,97,this);
     repaint();
   }  
   
   public int random(int min, int max)
   {
      return (int)(Math.random()*(max-min+1) + min);
   }
   
   public void actions(Object source, String command)
   {
      if (source == bDeal)
      {
         deal();
      }
      else if (source == cardA)
      {  
         this.remove(cardA);
         int r = random(0,51);
         cardA = new Card(deck[r],20,50,72,97,this);
         repaint();      // refresh window so image disappears
      }
      else if (source == cardB)
      {  
         this.remove(cardB);
         int r = random(0,51);
         cardB = new Card(deck[r],100,50,72,97,this);
         repaint();      // refresh window so image disappears
      }
      else if (source == cardC)
      {  
         this.remove(cardC);
         int r = random(0,51);
         cardC = new Card(deck[r],180,50,72,97,this);
         repaint();      // refresh window so image disappears
      }
      else if (source == cardD)
      {  
         this.remove(cardD);
         int r = random(0,51); 
         cardD = new Card(deck[r],260,50,72,97,this);
         repaint();      // refresh window so image disappears
      }
      else if (source == cardE)
      {  
         this.remove(cardE);
         int r = random(0,51);
         cardE = new Card(deck[r],340,50,72,97,this);
         repaint();      // refresh window so image disappears
      }
      
   }
}

class Card extends javax.swing.JLabel
{
   String code = "";
   
   public Card(String cardCode)
   {  
      ImageIcon im = new ImageIcon(cardCode + ".gif");
      int c = 0;
      do
      { c++;
      } while (c<100000 && im.getImageLoadStatus()!=java.awt.MediaTracker.COMPLETE);  
      this.setIcon(im);
      code = cardCode;
   }
   
   public Card(String cardCode,int x,int y,int w,int h,EasyApp app)
   {
      ImageIcon im = new ImageIcon(cardCode + ".gif");
      int c = 0;
      do
      { c++;
      } while (c<100000 && im.getImageLoadStatus()!=java.awt.MediaTracker.COMPLETE);    
      this.setIcon(im);
      addTo(x,y,w,h,app);
      code = cardCode;
   }

   public void addTo(int x,int y,int w,int h,EasyApp app)
   {
       app.add(this);
       this.setBounds(x,y,w,h);
       if (app!=null)this.addMouseListener(app);
   }

}
