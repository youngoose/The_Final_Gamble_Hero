package thefinalgamblehero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author EDDY JO
 */
public class TheFinalGambleHero extends Application
{
   static Stage stage1 = new Stage();
   static Stage stage2 = new Stage();
   static Stage stage3 = new Stage();
   static Stage stage4 = new Stage();

   static StartController c1;
   static GamePlayController c2;
   static FinishController c3;
   static SearchPlayerController c4;

   @Override
   public void start (Stage stage) throws Exception
   {
      FXMLLoader r1 = new FXMLLoader(getClass().getResource("Start.fxml"));
      FXMLLoader r2 = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
      FXMLLoader r3 = new FXMLLoader(getClass().getResource("Finish.fxml"));
      FXMLLoader r4 = new FXMLLoader(getClass().getResource("SearchPlayer.fxml"));

      Parent root1 = r1.load();
      Parent root2 = r2.load();
      Parent root3 = r3.load();
      Parent root4 = r4.load();

      c1 = r1.getController();
      c2 = r2.getController();
      c3 = r3.getController();
      c4 = r4.getController();

      Scene scene1 = new Scene(root1);
      Scene scene2 = new Scene(root2);
      Scene scene3 = new Scene(root3);
      Scene scene4 = new Scene(root4);

      stage1.setScene(scene1);
      stage2.setScene(scene2);
      stage3.setScene(scene3);
      stage4.setScene(scene4);

      show1();
   }

   public static void main (String[] args)
   {
      launch(args);
   }

   public static void show1 ()
   {
      stage1.show();
      stage2.hide();
      stage3.hide();
      stage4.hide();
   }

   public static void show2 ()
   {
      stage1.hide();
      stage2.show();
      stage3.hide();
      stage4.hide();
   }

   public static void show3 ()
   {
      stage1.hide();
      stage2.hide();
      stage3.show();
      stage4.hide();
   }

   public static void show4 ()
   {
      stage1.hide();
      stage2.hide();
      stage3.hide();
      stage4.show();
   }
}
