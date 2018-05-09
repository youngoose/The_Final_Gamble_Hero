package thefinalgamblehero;

public class Start implements Player,
        Comparable<Start>
{
   public int playerNumber = 0;
   public String playerName;
   public String playerCharacter;
   public int playerBettingAmount;
   public int playerTotalAmount;

   public Start ()
   {
   }

   public Start (String playerName, int playerTotalAmount)
   {
      this.playerName = playerName;
      this.playerTotalAmount = playerTotalAmount;
   }

   public Start (String playerName, String playerCharacter, int playerBettingAmount, int playerTotalAmount)
   {
      this.playerNumber++;
      this.playerName = playerName;
      this.playerCharacter = playerCharacter;
      this.playerBettingAmount = playerBettingAmount;
      this.playerTotalAmount = playerTotalAmount;
   }

   public void setPlayerNumber (int playerNumber)
   {
      this.playerNumber = playerNumber;
   }

   public int getPlayerNumber ()
   {
      return this.playerNumber;
   }

   public void setPlayerName (String playerName)
   {
      this.playerName = playerName;
   }

   @Override
   public String getPlayerName ()
   {
      return this.playerName;
   }

   public void setPlayerCharacter (String playerCharacter)
   {
      this.playerCharacter = playerCharacter;
   }

   @Override
   public String getPlayerCharacter ()
   {
      return this.playerCharacter;
   }

   public void setPlayerBettingAmount (int playerBettingAmount)
   {
      this.playerBettingAmount = playerBettingAmount;
   }

   @Override
   public int getPlayerBettingAmount ()
   {
      return this.playerBettingAmount;
   }

   public void setPlayerTotalAmount (int playerTotalAmount)
   {
      this.playerTotalAmount = playerTotalAmount;
   }

   public int getPlayerTotalAmount ()
   {
      return playerTotalAmount;
   }

   @Override
   public String toString ()
   {
      return "Player{name=" + this.playerName + ", total coin=" + this.playerTotalAmount + "}";
   }

   public int compareTo (Start s)
   {
      return s.playerTotalAmount - this.playerTotalAmount;
   }
}
