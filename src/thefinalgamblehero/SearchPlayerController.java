package thefinalgamblehero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;


public class SearchPlayerController implements Initializable
{
   @Override
   public void initialize (URL url, ResourceBundle rb)
   {

   }

   @FXML
   private Label player;

   @FXML
   private Label coin;

   @FXML
   public void GoToStartPage (ActionEvent event) throws IOException
   {
      this.player.setText("");
      this.coin.setText("");
      TheFinalGambleHero.show1();
   }

   @FXML
   public void loadPlayerRecord ()
   {
      this.readOnePlayer();
   }

   public void readOnePlayer ()
   {
      boolean recordExists = false;
      try {
         File file = new File("record.txt");
         if (!file.exists()) {
            throw new FileNotFoundException();
         }
         FileReader fr = new FileReader(file.getAbsoluteFile());
         BufferedReader br = new BufferedReader(fr);

         String s = "";
         String valueFromSearchBar = StartController.txt_searchValue;

         while ((s = br.readLine()) != null) {

            Pattern p = Pattern.compile("Player\\{name=(" + valueFromSearchBar + "), total coin=(\\d+)\\}");
            Matcher m = p.matcher(s);

            if (m.matches()) {
               recordExists = true;
               String name = m.group(1);
               int rank = Integer.parseInt(m.group(2));

               this.player.setText(name);
               this.coin.setText("$ " + Integer.toString(rank));
            }
         }
         if (!recordExists) {
            this.appendNewPlayerWith1000Coins();
            this.setAlert("Congratulation! We give you free $1000 coins as you're not registered yet !!");

         }
         valueFromSearchBar = "";
         br.close();
         fr.close();
      }
      catch (IOException e) {
         System.out.println(e);
      }
   }

   public void appendNewPlayerWith1000Coins ()
   {
      try {
         File file = new File("record.txt");
         if (!file.exists()) {
            file.createNewFile();
         }
         FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
         BufferedWriter bw = new BufferedWriter(fw);

         String newPlayer = StartController.txt_searchValue;
         bw.write("Player{name=" + newPlayer + ", total coin=1000}");
         bw.newLine();

         newPlayer = "";
         bw.close();
         fw.close();
      }
      catch (IOException e) {
         System.out.println(e);
      }
   }

   public void setAlert (String message)
   {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(message);
      alert.show();
   }
}
