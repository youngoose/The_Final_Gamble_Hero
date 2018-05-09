package thefinalgamblehero;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class StartController implements Initializable
{
   @FXML
   public MediaView mv;
   private MediaPlayer mp1;
   private MediaPlayer mp2;
   private Media me1;
   private Media me2;

   @FXML
   private TextField txt_search;
   public static String txt_searchValue;

   @FXML
   private TextField txt_player1;
   @FXML
   private TextField txt_player2;
   @FXML
   private TextField txt_player3;
   @FXML
   private TextField txt_player4;
   @FXML
   private TextField txt_player5;

   @FXML
   private TextField txt_p1Amount;
   @FXML
   private TextField txt_p2Amount;
   @FXML
   private TextField txt_p3Amount;
   @FXML
   private TextField txt_p4Amount;
   @FXML
   private TextField txt_p5Amount;

   @FXML
   private ChoiceBox mode;
   @FXML
   private ChoiceBox p1Character;
   @FXML
   private ChoiceBox p2Character;
   @FXML
   private ChoiceBox p3Character;
   @FXML
   private ChoiceBox p4Character;
   @FXML
   private ChoiceBox p5Character;

   @FXML
   private Button startBtn;

   public static ArrayList<Player> player = new ArrayList<Player>();
   public static int globalNumberOfPlayer = 0;
   public static boolean singlePlay = false;
   public static int p1TotalAmount = 0;
   public static int p2TotalAmount = 0;
   public static int p3TotalAmount = 0;
   public static int p4TotalAmount = 0;
   public static int p5TotalAmount = 0;
   public int numberOfEmptyNameField = 0;
   public int numberOfEmptyAmountField = 0;


   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      this.turnOnMainBG();

      mode.getItems().addAll("1", "2", "3", "4", "5");
      p1Character.getItems().addAll("Horse", "Simpson", "Batman", "Sonic", "Car");
      p2Character.getItems().addAll("Horse", "Simpson", "Batman", "Sonic", "Car");
      p3Character.getItems().addAll("Horse", "Simpson", "Batman", "Sonic", "Car");
      p4Character.getItems().addAll("Horse", "Simpson", "Batman", "Sonic", "Car");
      p5Character.getItems().addAll("Horse", "Simpson", "Batman", "Sonic", "Car");

      mode.setValue("1");
      p1Character.setValue("Horse");
      p2Character.setValue("Simpson");
      p3Character.setValue("Batman");
      p4Character.setValue("Sonic");
      p5Character.setValue("Car");
   }

   @FXML
   public void turnOnMainBG ()
   {
      String path1 = new File("src/media/casino.mp3").getAbsolutePath();
      me1 = new Media(new File(path1).toURI().toString());
      mp1 = new MediaPlayer(me1);
      mv.setMediaPlayer(mp1);
      mp1.setAutoPlay(true);
   }

   @FXML
   public void turnOffMainBG ()
   {
      mp1.pause();
   }

   private String getChoice (ChoiceBox<String> choiceBox)
   {
      String character = choiceBox.getValue();
      return character;
   }

   public ArrayList<Player> getList ()
   {
      return player;
   }

   @FXML
   public void GoToGamePage (ActionEvent event) throws IOException
   {
      numberOfEmptyNameField = 0;
      numberOfEmptyAmountField = 0;

      String numberOfPlayer = getChoice(this.mode);

      String p1Name = txt_player1.getText();
      String p2Name = txt_player2.getText();
      String p3Name = txt_player3.getText();
      String p4Name = txt_player4.getText();
      String p5Name = txt_player5.getText();

      String p1BettingAmountStr = txt_p1Amount.getText();
      String p2BettingAmountStr = txt_p2Amount.getText();
      String p3BettingAmountStr = txt_p3Amount.getText();
      String p4BettingAmountStr = txt_p4Amount.getText();
      String p5BettingAmountStr = txt_p5Amount.getText();

      if (p1Name.trim().isEmpty()) {
         numberOfEmptyNameField++;
      }
      if (p2Name.trim().isEmpty()) {
         numberOfEmptyNameField++;
      }
      if (p3Name.trim().isEmpty()) {
         numberOfEmptyNameField++;
      }
      if (p4Name.trim().isEmpty()) {
         numberOfEmptyNameField++;
      }
      if (p5Name.trim().isEmpty()) {
         numberOfEmptyNameField++;
      }

      if (p1BettingAmountStr.trim().isEmpty()) {
         numberOfEmptyAmountField++;
      }
      if (p2BettingAmountStr.trim().isEmpty()) {
         numberOfEmptyAmountField++;
      }
      if (p3BettingAmountStr.trim().isEmpty()) {
         numberOfEmptyAmountField++;
      }
      if (p4BettingAmountStr.trim().isEmpty()) {
         numberOfEmptyAmountField++;
      }
      if (p5BettingAmountStr.trim().isEmpty()) {
         numberOfEmptyAmountField++;
      }

      if (checkIfString(p1BettingAmountStr)) {
         setAlert("Please type valid amount");
      }
      if (checkIfString(p2BettingAmountStr)) {
         setAlert("Please type valid amount");
      }
      if (checkIfString(p3BettingAmountStr)) {
         setAlert("Please type valid amount");
      }
      if (checkIfString(p4BettingAmountStr)) {
         setAlert("Please type valid amount");
      }
      if (checkIfString(p5BettingAmountStr)) {
         setAlert("Please type valid amount");
      }

      if (numberOfPlayer == "1") {
         if (numberOfPlayer == "1" && (numberOfEmptyNameField != 4 || numberOfEmptyAmountField != 4)) {
            setAlert("Player numbers should be matched with your input : (");
         }
         else {
            if (!p1Name.trim().isEmpty() && !p1BettingAmountStr.trim().isEmpty()) {

               String p1Character = getChoice(this.p1Character);
               int p1BettingAmount = Integer.parseInt(p1BettingAmountStr);
               int p1TotalAmount = 0;
               if (p1Name != null && p1BettingAmount > 0) {
                  Start p1 = new Start(p1Name, p1Character, p1BettingAmount, p1TotalAmount);
                  player.add(p1);
                  globalNumberOfPlayer++;

                  this.singlePlay = true;
                  p2Name = "COM";
                  String p2Character = "Com";
                  int p2BettingAmount = 100;
                  int p2TotalAmount = 0;
                  if (p2Name != null && p2BettingAmount > 0) {
                     Start p2 = new Start(p2Name, p2Character, p2BettingAmount, p2TotalAmount);
                     player.add(p2);

                     TheFinalGambleHero.show2();
                     this.turnOffMainBG();
                  }
               }
            }
            else {
               setAlert("Please fill out Player 1 section");
            }
         }
      }
      else if (numberOfPlayer == "2") {
         if (numberOfPlayer == "2" && (numberOfEmptyNameField != 3 || numberOfEmptyAmountField != 3)) {
            setAlert("Player numbers should be matched with your input : (");
         }
         else {
            if ((!p1Name.trim().isEmpty() && !p1BettingAmountStr.trim().isEmpty())
                    && (!p2Name.trim().isEmpty() && !p2BettingAmountStr.trim().isEmpty())) {
               String p1Character = getChoice(this.p1Character);
               int p1BettingAmount = Integer.parseInt(p1BettingAmountStr);
               int p1TotalAmount = 0;
               if (p1Name != null && p1BettingAmount > 0) {
                  Start p1 = new Start(p1Name, p1Character, p1BettingAmount, p1TotalAmount);
                  player.add(p1);
                  globalNumberOfPlayer++;

                  String p2Character = getChoice(this.p2Character);
                  int p2BettingAmount = Integer.parseInt(p2BettingAmountStr);
                  int p2TotalAmount = 0;
                  if (p2Name != null && p2BettingAmount > 0) {
                     Start p2 = new Start(p2Name, p2Character, p2BettingAmount, p2TotalAmount);
                     player.add(p2);
                     globalNumberOfPlayer++;

                     TheFinalGambleHero.show2();
                     this.turnOffMainBG();
                  }
               }
            }
            else {
               setAlert("Please fill out Player 1 and Player 2 section");
            }
         }
      }

      else if (numberOfPlayer == "3") {
         if (numberOfPlayer == "3" && (numberOfEmptyNameField != 2 || numberOfEmptyAmountField != 2)) {
            setAlert("Player numbers should be matched with your input : (");
         }
         else {
            if ((!p1Name.trim().isEmpty() && !p1BettingAmountStr.trim().isEmpty())
                    && (!p2Name.trim().isEmpty() && !p2BettingAmountStr.trim().isEmpty())
                    && (!p3Name.trim().isEmpty() && !p3BettingAmountStr.trim().isEmpty())) {
               String p1Character = getChoice(this.p1Character);
               int p1BettingAmount = Integer.parseInt(p1BettingAmountStr);
               if (p1Name != null && p1BettingAmount > 0) {
                  int p1TotalAmount = 0;
                  Start p1 = new Start(p1Name, p1Character, p1BettingAmount, p1TotalAmount);
                  player.add(p1);
                  globalNumberOfPlayer++;

                  String p2Character = getChoice(this.p2Character);
                  int p2BettingAmount = Integer.parseInt(p2BettingAmountStr);
                  int p2TotalAmount = 0;
                  if (p2Name != null && p2BettingAmount > 0) {
                     Start p2 = new Start(p2Name, p2Character, p2BettingAmount, p2TotalAmount);
                     player.add(p2);
                     globalNumberOfPlayer++;

                     String p3Character = getChoice(this.p3Character);
                     int p3BettingAmount = Integer.parseInt(p3BettingAmountStr);
                     int p3TotalAmount = 0;
                     if (p3Name != null && p3BettingAmount > 0) {
                        Start p3 = new Start(p3Name, p3Character, p3BettingAmount, p3TotalAmount);
                        player.add(p3);
                        globalNumberOfPlayer++;

                        TheFinalGambleHero.show2();
                        this.turnOffMainBG();
                     }
                  }
               }
            }
            else {
               setAlert("Please fill out Player 1, Player 2 and Player 3 section");
            }
         }
      }
      else if (numberOfPlayer == "4") {
         if (numberOfPlayer == "4" && (numberOfEmptyNameField != 1 || numberOfEmptyAmountField != 1)) {
            setAlert("Player numbers should be matched with your input : (");
         }
         else {
            if ((!p1Name.trim().isEmpty() && !p1BettingAmountStr.trim().isEmpty())
                    && (!p2Name.trim().isEmpty() && !p2BettingAmountStr.trim().isEmpty())
                    && (!p3Name.trim().isEmpty() && !p3BettingAmountStr.trim().isEmpty())
                    && (!p4Name.trim().isEmpty() && !p4BettingAmountStr.trim().isEmpty())) {
               String p1Character = getChoice(this.p1Character);
               int p1BettingAmount = Integer.parseInt(p1BettingAmountStr);
               int p1TotalAmount = 0;
               if (p1Name != null && p1BettingAmount > 0) {
                  Start p1 = new Start(p1Name, p1Character, p1BettingAmount, p1TotalAmount);
                  player.add(p1);
                  globalNumberOfPlayer++;

                  String p2Character = getChoice(this.p2Character);
                  int p2BettingAmount = Integer.parseInt(p2BettingAmountStr);
                  int p2TotalAmount = 0;
                  if (p2Name != null && p2BettingAmount > 0) {
                     Start p2 = new Start(p2Name, p2Character, p2BettingAmount, p2TotalAmount);
                     player.add(p2);
                     globalNumberOfPlayer++;

                     String p3Character = getChoice(this.p3Character);
                     int p3BettingAmount = Integer.parseInt(p3BettingAmountStr);
                     int p3TotalAmount = 0;
                     if (p3Name != null && p3BettingAmount > 0) {
                        Start p3 = new Start(p3Name, p3Character, p3BettingAmount, p3TotalAmount);
                        player.add(p3);
                        globalNumberOfPlayer++;

                        String p4Character = getChoice(this.p4Character);
                        int p4BettingAmount = Integer.parseInt(p4BettingAmountStr);
                        int p4TotalAmount = 0;
                        if (p4Name != null && p4BettingAmount > 0) {
                           Start p4 = new Start(p4Name, p4Character, p4BettingAmount, p4TotalAmount);
                           player.add(p4);
                           globalNumberOfPlayer++;

                           TheFinalGambleHero.show2();
                           this.turnOffMainBG();
                        }
                     }
                  }
               }
            }
            else {
               setAlert("Please fill out from Player 1 to Player 4 section");
            }
         }
      }
      else if (numberOfPlayer == "5") {
         if (numberOfPlayer == "5" && (numberOfEmptyNameField != 0 || numberOfEmptyAmountField != 0)) {
            setAlert("Player numbers should be matched with your input : (");
         }
         else {
            if ((!p1Name.trim().isEmpty() && !p1BettingAmountStr.trim().isEmpty())
                    && (!p2Name.trim().isEmpty() && !p2BettingAmountStr.trim().isEmpty())
                    && (!p3Name.trim().isEmpty() && !p3BettingAmountStr.trim().isEmpty())
                    && (!p4Name.trim().isEmpty() && !p4BettingAmountStr.trim().isEmpty())) {
               String p1Character = getChoice(this.p1Character);
               int p1BettingAmount = Integer.parseInt(p1BettingAmountStr);
               int p1TotalAmount = 0;
               if (p1Name != null && p1BettingAmount > 0) {
                  Start p1 = new Start(p1Name, p1Character, p1BettingAmount, p1TotalAmount);
                  player.add(p1);
                  globalNumberOfPlayer++;

                  String p2Character = getChoice(this.p2Character);
                  int p2BettingAmount = Integer.parseInt(p2BettingAmountStr);
                  int p2TotalAmount = 0;
                  if (p2Name != null && p2BettingAmount > 0) {
                     Start p2 = new Start(p2Name, p2Character, p2BettingAmount, p2TotalAmount);
                     player.add(p2);
                     globalNumberOfPlayer++;

                     String p3Character = getChoice(this.p3Character);
                     int p3BettingAmount = Integer.parseInt(p3BettingAmountStr);
                     int p3TotalAmount = 0;
                     if (p3Name != null && p3BettingAmount > 0) {
                        Start p3 = new Start(p3Name, p3Character, p3BettingAmount, p3TotalAmount);
                        player.add(p3);
                        globalNumberOfPlayer++;

                        String p4Character = getChoice(this.p4Character);
                        int p4BettingAmount = Integer.parseInt(p4BettingAmountStr);
                        int p4TotalAmount = 0;
                        if (p4Name != null && p4BettingAmount > 0) {
                           Start p4 = new Start(p4Name, p4Character, p4BettingAmount, p4TotalAmount);
                           player.add(p4);
                           globalNumberOfPlayer++;

                           String p5Character = getChoice(this.p5Character);
                           int p5BettingAmount = Integer.parseInt(p5BettingAmountStr);
                           int p5TotalAmount = 0;
                           if (p5Name != null && p5BettingAmount > 0) {
                              Start p5 = new Start(p5Name, p5Character, p5BettingAmount, p5TotalAmount);
                              player.add(p5);
                              globalNumberOfPlayer++;

                              TheFinalGambleHero.show2();
                              this.turnOffMainBG();
                           }
                        }
                     }
                  }
               }
            }
         }
      }
      txt_player1.setText("");
      txt_player2.setText("");
      txt_player3.setText("");
      txt_player4.setText("");
      txt_player5.setText("");

      txt_p1Amount.setText("");
      txt_p2Amount.setText("");
      txt_p3Amount.setText("");
      txt_p4Amount.setText("");
      txt_p5Amount.setText("");
   }

   public boolean checkIfString (String text)
   {
      Pattern p = Pattern.compile("[a-zA-Z]+");
      Matcher m = p.matcher(text);
      if (m.matches()) {
         txt_player1.setText("");
         txt_player2.setText("");
         txt_player3.setText("");
         txt_player4.setText("");
         txt_player5.setText("");
         txt_p1Amount.setText("");
         txt_p2Amount.setText("");
         txt_p3Amount.setText("");
         txt_p4Amount.setText("");
         txt_p5Amount.setText("");
         return true;
      }
      return false;
   }

   public void setAlert (String message)
   {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText(message);
      alert.show();
   }

   @FXML
   public void GoToSearchPlayer (ActionEvent event) throws IOException
   {
      if (this.txt_search.getText().trim().isEmpty()) {
         setAlert("Please type player name");
      }
      else {
         StartController.txt_searchValue = "";
         StartController.txt_searchValue = this.txt_search.getText();
         this.txt_search.setText("");
         TheFinalGambleHero.show4();
      }
   }

}
