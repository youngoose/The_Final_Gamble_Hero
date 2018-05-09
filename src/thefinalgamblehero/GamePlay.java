package thefinalgamblehero;
import javafx.scene.image.Image;

public class GamePlay
{
   private final Image HORSE = new Image("images/horse.gif", 136, 115, false, false);
   private final Image SIMPSON = new Image("images/simpson.gif", 160, 145, false, false);
   private final Image BATMAN = new Image("images/batman.gif", 144, 135, false, false);
   private final Image SONIC = new Image("images/sonic.gif", 100, 70, false, false);
   private final Image CAR = new Image("images/car.gif", 120, 140, false, false);
   private final Image COM = new Image("images/com.gif", 110, 90, false, false);
   private final Image POLICE = new Image("images/police.gif", 140, 100, false, false);
   private Image selectedCharacter;

   private int numberOfPlayer;

   private int LEG1 = 500;
   private int LEG2 = 900;
   private int LEG3 = 1350;

   public GamePlay ()
   {

   }

   public GamePlay (int numberOfPlayer)
   {
      this.numberOfPlayer = numberOfPlayer;
   }

   public Image getHORSE ()
   {
      return HORSE;
   }

   public Image getBATMAN ()
   {
      return BATMAN;
   }

   public Image getSIMPSON ()
   {
      return SIMPSON;
   }

   public Image getSONIC ()
   {
      return SONIC;
   }

   public Image getCAR ()
   {
      return CAR;
   }

   public void setSelectedCharacter (String selectedCharacter)
   {
      switch (selectedCharacter) {
         case "horse":
            this.selectedCharacter = HORSE;
            break;
         case "simpson":
            this.selectedCharacter = SIMPSON;
            break;
         case "batman":
            this.selectedCharacter = BATMAN;
            break;
         case "sonic":
            this.selectedCharacter = SONIC;
            break;
         case "car":
            this.selectedCharacter = CAR;
            break;
         case "com":
            this.selectedCharacter = COM;
            break;
         case "police":
            this.selectedCharacter = POLICE;
            break;
      }
   }

   public Image getSelectedCharacter ()
   {
      return this.selectedCharacter;
   }
}
