package thefinalgamblehero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class FinishController implements Initializable
{
   @FXML
   private MediaView mv;
   private MediaPlayer mp;
   private Media me;

   @FXML
   private GridPane recordGrid;

   @FXML
   private Button loadRecord;

   @FXML
   private Label rank1Name;
   @FXML
   private Label rank2Name;
   @FXML
   private Label rank3Name;
   @FXML
   private Label rank4Name;
   @FXML
   private Label rank5Name;
   @FXML
   private Label rank6Name;
   @FXML
   private Label rank7Name;
   @FXML
   private Label rank8Name;
   @FXML
   private Label rank9Name;
   @FXML
   private Label rank10Name;

   @FXML
   private Label rank1Coin;
   @FXML
   private Label rank2Coin;
   @FXML
   private Label rank3Coin;
   @FXML
   private Label rank4Coin;
   @FXML
   private Label rank5Coin;
   @FXML
   private Label rank6Coin;
   @FXML
   private Label rank7Coin;
   @FXML
   private Label rank8Coin;
   @FXML
   private Label rank9Coin;
   @FXML
   private Label rank10Coin;


   @Override
   public void initialize (URL url, ResourceBundle rb)
   {

   }

   @FXML
   public void callRecord ()
   {
      this.turnOnBG();
      this.readPlayers();
      loadRecord.setDisable(true);
   }

   @FXML
   public void turnOnBG ()
   {
      String path = new File("src/media/rank.mp3").getAbsolutePath();
      me = new Media(new File(path).toURI().toString());
      mp = new MediaPlayer(me);
      mv.setMediaPlayer(mp);
      mp.setAutoPlay(true);
   }

   public void readPlayers ()
   {
      TreeSet<Start> ranks = new TreeSet();

      try {
         File file = new File("record.txt");
         if (!file.exists()) {
            throw new FileNotFoundException();
         }
         FileReader fr = new FileReader(file.getAbsoluteFile());
         BufferedReader br = new BufferedReader(fr);

         String s = "";

         while ((s = br.readLine()) != null) {

            Pattern p = Pattern.compile("Player\\{name=(.+), total coin=(\\d+)\\}");
            Matcher m = p.matcher(s);

            if (m.matches()) {
               String name = m.group(1);
               int rank = Integer.parseInt(m.group(2));
               ranks.add(new Start(name, rank));
            }
         }

         ArrayList<Start> rankNames = new ArrayList(ranks);

         if (ranks.size() < 10) {
            switch (ranks.size()) {
               case 1:
                  rank1Name.setText(rankNames.get(0).playerName);
                  rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
                  break;
               case 2:
                  rank1Name.setText(rankNames.get(0).playerName);
                  rank2Name.setText(rankNames.get(1).playerName);
                  rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
                  rank2Coin.setText(Integer.toString(rankNames.get(1).playerTotalAmount));
                  break;
               case 3:
                  rank1Name.setText(rankNames.get(0).playerName);
                  rank2Name.setText(rankNames.get(1).playerName);
                  rank3Name.setText(rankNames.get(2).playerName);
                  rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
                  rank2Coin.setText(Integer.toString(rankNames.get(1).playerTotalAmount));
                  rank3Coin.setText(Integer.toString(rankNames.get(2).playerTotalAmount));
                  break;
               case 4:
                  rank1Name.setText(rankNames.get(0).playerName);
                  rank2Name.setText(rankNames.get(1).playerName);
                  rank3Name.setText(rankNames.get(2).playerName);
                  rank4Name.setText(rankNames.get(3).playerName);
                  rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
                  rank2Coin.setText(Integer.toString(rankNames.get(1).playerTotalAmount));
                  rank3Coin.setText(Integer.toString(rankNames.get(2).playerTotalAmount));
                  rank4Coin.setText(Integer.toString(rankNames.get(3).playerTotalAmount));
                  break;
               case 5:
                  rank1Name.setText(rankNames.get(0).playerName);
                  rank2Name.setText(rankNames.get(1).playerName);
                  rank3Name.setText(rankNames.get(2).playerName);
                  rank4Name.setText(rankNames.get(3).playerName);
                  rank5Name.setText(rankNames.get(4).playerName);
                  rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
                  rank2Coin.setText(Integer.toString(rankNames.get(1).playerTotalAmount));
                  rank3Coin.setText(Integer.toString(rankNames.get(2).playerTotalAmount));
                  rank4Coin.setText(Integer.toString(rankNames.get(3).playerTotalAmount));
                  rank5Coin.setText(Integer.toString(rankNames.get(4).playerTotalAmount));
                  break;
               case 6:
                  rank1Name.setText(rankNames.get(0).playerName);
                  rank2Name.setText(rankNames.get(1).playerName);
                  rank3Name.setText(rankNames.get(2).playerName);
                  rank4Name.setText(rankNames.get(3).playerName);
                  rank5Name.setText(rankNames.get(4).playerName);
                  rank6Name.setText(rankNames.get(5).playerName);
                  rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
                  rank2Coin.setText(Integer.toString(rankNames.get(1).playerTotalAmount));
                  rank3Coin.setText(Integer.toString(rankNames.get(2).playerTotalAmount));
                  rank4Coin.setText(Integer.toString(rankNames.get(3).playerTotalAmount));
                  rank5Coin.setText(Integer.toString(rankNames.get(4).playerTotalAmount));
                  rank6Coin.setText(Integer.toString(rankNames.get(5).playerTotalAmount));
                  break;
               case 7:
                  rank1Name.setText(rankNames.get(0).playerName);
                  rank2Name.setText(rankNames.get(1).playerName);
                  rank3Name.setText(rankNames.get(2).playerName);
                  rank4Name.setText(rankNames.get(3).playerName);
                  rank5Name.setText(rankNames.get(4).playerName);
                  rank6Name.setText(rankNames.get(5).playerName);
                  rank7Name.setText(rankNames.get(6).playerName);
                  rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
                  rank2Coin.setText(Integer.toString(rankNames.get(1).playerTotalAmount));
                  rank3Coin.setText(Integer.toString(rankNames.get(2).playerTotalAmount));
                  rank4Coin.setText(Integer.toString(rankNames.get(3).playerTotalAmount));
                  rank5Coin.setText(Integer.toString(rankNames.get(4).playerTotalAmount));
                  rank6Coin.setText(Integer.toString(rankNames.get(5).playerTotalAmount));
                  rank7Coin.setText(Integer.toString(rankNames.get(6).playerTotalAmount));
                  break;
               case 8:
                  rank1Name.setText(rankNames.get(0).playerName);
                  rank2Name.setText(rankNames.get(1).playerName);
                  rank3Name.setText(rankNames.get(2).playerName);
                  rank4Name.setText(rankNames.get(3).playerName);
                  rank5Name.setText(rankNames.get(4).playerName);
                  rank6Name.setText(rankNames.get(5).playerName);
                  rank7Name.setText(rankNames.get(6).playerName);
                  rank8Name.setText(rankNames.get(7).playerName);
                  rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
                  rank2Coin.setText(Integer.toString(rankNames.get(1).playerTotalAmount));
                  rank3Coin.setText(Integer.toString(rankNames.get(2).playerTotalAmount));
                  rank4Coin.setText(Integer.toString(rankNames.get(3).playerTotalAmount));
                  rank5Coin.setText(Integer.toString(rankNames.get(4).playerTotalAmount));
                  rank6Coin.setText(Integer.toString(rankNames.get(5).playerTotalAmount));
                  rank7Coin.setText(Integer.toString(rankNames.get(6).playerTotalAmount));
                  rank8Coin.setText(Integer.toString(rankNames.get(7).playerTotalAmount));
                  break;
               case 9:
                  rank1Name.setText(rankNames.get(0).playerName);
                  rank2Name.setText(rankNames.get(1).playerName);
                  rank3Name.setText(rankNames.get(2).playerName);
                  rank4Name.setText(rankNames.get(3).playerName);
                  rank5Name.setText(rankNames.get(4).playerName);
                  rank6Name.setText(rankNames.get(5).playerName);
                  rank7Name.setText(rankNames.get(6).playerName);
                  rank8Name.setText(rankNames.get(7).playerName);
                  rank9Name.setText(rankNames.get(8).playerName);
                  rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
                  rank2Coin.setText(Integer.toString(rankNames.get(1).playerTotalAmount));
                  rank3Coin.setText(Integer.toString(rankNames.get(2).playerTotalAmount));
                  rank4Coin.setText(Integer.toString(rankNames.get(3).playerTotalAmount));
                  rank5Coin.setText(Integer.toString(rankNames.get(4).playerTotalAmount));
                  rank6Coin.setText(Integer.toString(rankNames.get(5).playerTotalAmount));
                  rank7Coin.setText(Integer.toString(rankNames.get(6).playerTotalAmount));
                  rank8Coin.setText(Integer.toString(rankNames.get(7).playerTotalAmount));
                  rank9Coin.setText(Integer.toString(rankNames.get(8).playerTotalAmount));
                  break;
               case 10:
                  rank1Name.setText(rankNames.get(0).playerName);
                  rank2Name.setText(rankNames.get(1).playerName);
                  rank3Name.setText(rankNames.get(2).playerName);
                  rank4Name.setText(rankNames.get(3).playerName);
                  rank5Name.setText(rankNames.get(4).playerName);
                  rank6Name.setText(rankNames.get(5).playerName);
                  rank7Name.setText(rankNames.get(6).playerName);
                  rank8Name.setText(rankNames.get(7).playerName);
                  rank9Name.setText(rankNames.get(8).playerName);
                  rank10Name.setText(rankNames.get(9).playerName);
                  rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
                  rank2Coin.setText(Integer.toString(rankNames.get(1).playerTotalAmount));
                  rank3Coin.setText(Integer.toString(rankNames.get(2).playerTotalAmount));
                  rank4Coin.setText(Integer.toString(rankNames.get(3).playerTotalAmount));
                  rank5Coin.setText(Integer.toString(rankNames.get(4).playerTotalAmount));
                  rank6Coin.setText(Integer.toString(rankNames.get(5).playerTotalAmount));
                  rank7Coin.setText(Integer.toString(rankNames.get(6).playerTotalAmount));
                  rank8Coin.setText(Integer.toString(rankNames.get(7).playerTotalAmount));
                  rank9Coin.setText(Integer.toString(rankNames.get(8).playerTotalAmount));
                  rank10Coin.setText(Integer.toString(rankNames.get(9).playerTotalAmount));
                  break;
            }
         }
         else {
            rank1Name.setText(rankNames.get(0).playerName);
            rank2Name.setText(rankNames.get(1).playerName);
            rank3Name.setText(rankNames.get(2).playerName);
            rank4Name.setText(rankNames.get(3).playerName);
            rank5Name.setText(rankNames.get(4).playerName);
            rank6Name.setText(rankNames.get(5).playerName);
            rank7Name.setText(rankNames.get(6).playerName);
            rank8Name.setText(rankNames.get(7).playerName);
            rank9Name.setText(rankNames.get(8).playerName);
            rank10Name.setText(rankNames.get(9).playerName);
            rank1Coin.setText(Integer.toString(rankNames.get(0).playerTotalAmount));
            rank2Coin.setText(Integer.toString(rankNames.get(1).playerTotalAmount));
            rank3Coin.setText(Integer.toString(rankNames.get(2).playerTotalAmount));
            rank4Coin.setText(Integer.toString(rankNames.get(3).playerTotalAmount));
            rank5Coin.setText(Integer.toString(rankNames.get(4).playerTotalAmount));
            rank6Coin.setText(Integer.toString(rankNames.get(5).playerTotalAmount));
            rank7Coin.setText(Integer.toString(rankNames.get(6).playerTotalAmount));
            rank8Coin.setText(Integer.toString(rankNames.get(7).playerTotalAmount));
            rank9Coin.setText(Integer.toString(rankNames.get(8).playerTotalAmount));
            rank10Coin.setText(Integer.toString(rankNames.get(9).playerTotalAmount));
         }
         br.close();
         fr.close();
      }
      catch (IOException e) {
         System.out.println(e);
      }
   }

}
