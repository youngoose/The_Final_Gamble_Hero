package thefinalgamblehero;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class GamePlayController implements Initializable
{
   @FXML
   private MediaView mv;
   private MediaPlayer mp1;
   private MediaPlayer mp2;
   private MediaPlayer mp3;
   private MediaPlayer mp4;
   private Media me1;
   private Media me2;
   private Media me3;
   private Media me4;

   @FXML
   private GridPane chracterGrid;

   @FXML
   private Label p1Name;
   @FXML
   private Label p2Name;
   @FXML
   private Label p3Name;
   @FXML
   private Label p4Name;
   @FXML
   private Label p5Name;


   @FXML
   private Label p1Tname;
   @FXML
   private Label p2Tname;
   @FXML
   private Label p3Tname;
   @FXML
   private Label p4Tname;
   @FXML
   private Label p5Tname;

   @FXML
   private Label p1BettingAmount;
   @FXML
   private Label p2BettingAmount;
   @FXML
   private Label p3BettingAmount;
   @FXML
   private Label p4BettingAmount;
   @FXML
   private Label p5BettingAmount;

   @FXML
   private Button set;
   @FXML
   private Button start;
   @FXML
   private Label p1Police;
   @FXML
   private Label p2Police;
   @FXML
   private Label p3Police;
   @FXML
   private Label p4Police;
   @FXML
   private Label p5Police;

   @FXML
   private Label p1Rank;
   @FXML
   private Label p2Rank;
   @FXML
   private Label p3Rank;
   @FXML
   private Label p4Rank;
   @FXML
   private Label p5Rank;

   @FXML
   private Label p1ItemMessage;
   @FXML
   private Label p2ItemMessage;
   @FXML
   private Label p3ItemMessage;
   @FXML
   private Label p4ItemMessage;
   @FXML
   private Label p5ItemMessage;

   @FXML
   private Label p1TotalAmountMessage;
   @FXML
   private Label p2TotalAmountMessage;
   @FXML
   private Label p3TotalAmountMessage;
   @FXML
   private Label p4TotalAmountMessage;
   @FXML
   private Label p5TotalAmountMessage;

   @FXML
   public ImageView p1;
   @FXML
   public ImageView p2;
   @FXML
   public ImageView p3;
   @FXML
   public ImageView p4;
   @FXML
   public ImageView p5;

   public int p1Item = 0;
   public int p2Item = 0;
   public int p3Item = 0;
   public int p4Item = 0;
   public int p5Item = 0;

   public boolean p1SpeedUp = false;
   public boolean p2SpeedUp = false;
   public boolean p3SpeedUp = false;
   public boolean p4SpeedUp = false;
   public boolean p5SpeedUp = false;

   public boolean p1Transport = false;
   public boolean p2Transport = false;
   public boolean p3Transport = false;
   public boolean p4Transport = false;
   public boolean p5Transport = false;

   public boolean p1PoliceFrozen = false;
   public boolean p2PoliceFrozen = false;
   public boolean p3PoliceFrozen = false;
   public boolean p4PoliceFrozen = false;
   public boolean p5PoliceFrozen = false;

   private int rank = 0;

   @Override
   public void initialize (URL url, ResourceBundle rb)
   {
      this.p1Police.setVisible(false);
      this.p2Police.setVisible(false);
      this.p3Police.setVisible(false);
      this.p4Police.setVisible(false);
      this.p5Police.setVisible(false);
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

   @FXML
   public void turnOnReady ()
   {
      String path2 = new File("src/media/ready.mp3").getAbsolutePath();
      me2 = new Media(new File(path2).toURI().toString());
      mp2 = new MediaPlayer(me2);
      mv.setMediaPlayer(mp2);
      mv.setMediaPlayer(mp2);
      mp2.setAutoPlay(true);
   }

   @FXML
   public void turnOffFanfare ()
   {
      mp2.pause();
   }

   @FXML
   public void turnOnSiren ()
   {
      String path3 = new File("src/media/police.mp3").getAbsolutePath();
      me3 = new Media(new File(path3).toURI().toString());
      mp3 = new MediaPlayer(me3);
      mv.setMediaPlayer(mp3);
      mv.setMediaPlayer(mp3);
      mp3.setAutoPlay(true);
   }

   @FXML
   public void turnOffSiren ()
   {
      mp3.pause();
   }

   public void turnOnWinnerMusic ()
   {
      String path4 = new File("src/media/endRace.mp3").getAbsolutePath();
      me4 = new Media(new File(path4).toURI().toString());
      mp4 = new MediaPlayer(me4);
      mv.setMediaPlayer(mp4);
      mv.setMediaPlayer(mp4);
      mp4.setAutoPlay(true);
   }

   public void turnOffWinnerMusic ()
   {
      mp4.pause();
   }

   @FXML
   public void setPlayers ()
   {
      this.turnOnReady();

      Random police = new Random();
      int policeNum = 0;
      if (StartController.globalNumberOfPlayer == 1) {
         policeNum = police.nextInt(2) + 1;
      }
      else if (StartController.globalNumberOfPlayer == 2) {
         policeNum = police.nextInt(2) + 1;
      }
      else if (StartController.globalNumberOfPlayer == 3) {
         policeNum = police.nextInt(3) + 1;
      }
      else if (StartController.globalNumberOfPlayer == 4) {
         policeNum = police.nextInt(4) + 1;
      }
      else if (StartController.globalNumberOfPlayer == 5) {
         policeNum = police.nextInt(5) + 1;
      }

      switch (policeNum) {
         case 1:
            this.p1PoliceFrozen = true;
            this.p1Police.setVisible(true);
            break;
         case 2:
            this.p2PoliceFrozen = true;
            this.p2Police.setVisible(true);
            break;
         case 3:
            this.p3PoliceFrozen = true;
            this.p3Police.setVisible(true);
            break;
         case 4:
            this.p4PoliceFrozen = true;
            this.p4Police.setVisible(true);
            break;
         case 5:
            this.p5PoliceFrozen = true;
            this.p5Police.setVisible(true);
            break;
      }

      Random rnd1 = new Random();
      int rndItem1 = rnd1.nextInt(2) + 1;
      this.p1Item = rndItem1;
      if (this.p1Item == 1) {
         this.p1SpeedUp = true;
         this.p1ItemMessage.setText("Speed up");
      }
      else {
         this.p1Transport = true;
         this.p1ItemMessage.setText("Transport");
      }

      Random rnd2 = new Random();
      int rndItem2 = rnd2.nextInt(2) + 1;
      this.p2Item = rndItem2;
      if (this.p2Item == 1) {
         this.p2SpeedUp = true;
         this.p2ItemMessage.setText("Speed up");
      }
      else {
         this.p2Transport = true;
         this.p2ItemMessage.setText("Transport");
      }

      Random rnd3 = new Random();
      int rndItem3 = rnd3.nextInt(2) + 1;
      this.p3Item = rndItem3;
      if (this.p3Item == 1) {
         this.p3SpeedUp = true;
         this.p3ItemMessage.setText("Speed up");
      }
      else {
         this.p3Transport = true;
         this.p3ItemMessage.setText("Transport");
      }

      Random rnd4 = new Random();
      int rndItem4 = rnd4.nextInt(2) + 1;
      this.p4Item = rndItem4;
      if (this.p4Item == 1) {
         this.p4SpeedUp = true;
         this.p4ItemMessage.setText("Speed up");
      }
      else {
         this.p4Transport = true;
         this.p4ItemMessage.setText("Transport");
      }

      Random rnd5 = new Random();
      int rndItem5 = rnd5.nextInt(2) + 1;
      this.p5Item = rndItem5;
      if (this.p5Item == 1) {
         this.p5SpeedUp = true;
         this.p5ItemMessage.setText("Speed up");
      }
      else {
         this.p5Transport = true;
         this.p5ItemMessage.setText("Transport");
      }
      this.p1ItemMessage.setVisible(false);
      this.p2ItemMessage.setVisible(false);
      this.p3ItemMessage.setVisible(false);
      this.p4ItemMessage.setVisible(false);
      this.p5ItemMessage.setVisible(false);

      StartController sc = new StartController();

      if (StartController.globalNumberOfPlayer == 1 && StartController.singlePlay == true) {
         p1Name.setText(sc.getList().get(0).getPlayerName());
         p1Tname.setText(sc.getList().get(0).getPlayerName());
         p1BettingAmount.setText("$ " + Integer.toString(sc.getList().get(0).getPlayerBettingAmount()));

         GamePlay gp1 = new GamePlay();

         if (this.p1PoliceFrozen) {
            gp1.setSelectedCharacter("police");
            this.p1Police.setVisible(true);
         }
         else {
            gp1.setSelectedCharacter(sc.getList().get(0).getPlayerCharacter().toLowerCase());
         }

         Image imgP1 = gp1.getSelectedCharacter();
         p1 = new ImageView(imgP1);
         chracterGrid.add(p1, 0, 0);

         p2Name.setText(sc.getList().get(1).getPlayerName());
         p2Tname.setText(sc.getList().get(1).getPlayerName());
         p2BettingAmount.setText("$ " + Integer.toString(sc.getList().get(1).getPlayerBettingAmount()));
         GamePlay gp2 = new GamePlay();

         if (this.p2PoliceFrozen) {
            gp2.setSelectedCharacter("police");
            this.p2Police.setVisible(true);
         }
         else {
            gp2.setSelectedCharacter(sc.getList().get(1).getPlayerCharacter().toLowerCase());
         }

         Image imgP2 = gp2.getSelectedCharacter();
         p2 = new ImageView(imgP2);
         chracterGrid.add(p2, 0, 1);

         this.p1ItemMessage.setVisible(true);
         this.p2ItemMessage.setVisible(true);
         this.p3ItemMessage.setVisible(false);
         this.p4ItemMessage.setVisible(false);
         this.p5ItemMessage.setVisible(false);

      }
      else if (StartController.globalNumberOfPlayer == 2) {
         p1Name.setText(sc.getList().get(0).getPlayerName());
         p1Tname.setText(sc.getList().get(0).getPlayerName());
         p1BettingAmount.setText("$ " + Integer.toString(sc.getList().get(0).getPlayerBettingAmount()));

         GamePlay gp1 = new GamePlay();
         if (this.p1PoliceFrozen) {
            gp1.setSelectedCharacter("police");
            this.p1Police.setVisible(true);
         }
         else {
            gp1.setSelectedCharacter(sc.getList().get(0).getPlayerCharacter().toLowerCase());
         }
         Image imgP1 = gp1.getSelectedCharacter();
         p1 = new ImageView(imgP1);
         chracterGrid.add(p1, 0, 0);

         p2Name.setText(sc.getList().get(1).getPlayerName());
         p2Tname.setText(sc.getList().get(1).getPlayerName());
         p2BettingAmount.setText("$ " + Integer.toString(sc.getList().get(1).getPlayerBettingAmount()));
         GamePlay gp2 = new GamePlay();

         if (this.p2PoliceFrozen) {
            gp2.setSelectedCharacter("police");
            this.p2Police.setVisible(true);
         }
         else {
            gp2.setSelectedCharacter(sc.getList().get(1).getPlayerCharacter().toLowerCase());
         }

         Image imgP2 = gp2.getSelectedCharacter();
         p2 = new ImageView(imgP2);
         chracterGrid.add(p2, 0, 1);

         this.p1ItemMessage.setVisible(true);
         this.p2ItemMessage.setVisible(true);
         this.p3ItemMessage.setVisible(false);
         this.p4ItemMessage.setVisible(false);
         this.p5ItemMessage.setVisible(false);
      }

      else if (StartController.globalNumberOfPlayer == 3) {
         p1Name.setText(sc.getList().get(0).getPlayerName());
         p1Tname.setText(sc.getList().get(0).getPlayerName());
         p1BettingAmount.setText("$ " + Integer.toString(sc.getList().get(0).getPlayerBettingAmount()));
         GamePlay gp1 = new GamePlay();

         if (this.p1PoliceFrozen) {
            gp1.setSelectedCharacter("police");
            this.p1Police.setVisible(true);
         }
         else {
            gp1.setSelectedCharacter(sc.getList().get(0).getPlayerCharacter().toLowerCase());
         }

         Image imgP1 = gp1.getSelectedCharacter();
         p1 = new ImageView(imgP1);
         chracterGrid.add(p1, 0, 0);

         p2Name.setText(sc.getList().get(1).getPlayerName());
         p2Tname.setText(sc.getList().get(1).getPlayerName());
         p2BettingAmount.setText("$ " + Integer.toString(sc.getList().get(1).getPlayerBettingAmount()));
         GamePlay gp2 = new GamePlay();
         if (this.p2PoliceFrozen) {
            gp2.setSelectedCharacter("police");
            this.p2Police.setVisible(true);
         }
         else {
            gp2.setSelectedCharacter(sc.getList().get(1).getPlayerCharacter().toLowerCase());
         }
         Image imgP2 = gp2.getSelectedCharacter();
         p2 = new ImageView(imgP2);
         chracterGrid.add(p2, 0, 1);

         p3Name.setText(sc.getList().get(2).getPlayerName());
         p3Tname.setText(sc.getList().get(2).getPlayerName());
         p3BettingAmount.setText("$ " + Integer.toString(sc.getList().get(2).getPlayerBettingAmount()));
         GamePlay gp3 = new GamePlay();

         if (this.p3PoliceFrozen) {
            gp3.setSelectedCharacter("police");
            this.p3Police.setVisible(true);
         }
         else {
            gp3.setSelectedCharacter(sc.getList().get(2).getPlayerCharacter().toLowerCase());
         }

         Image imgP3 = gp3.getSelectedCharacter();
         p3 = new ImageView(imgP3);
         chracterGrid.add(p3, 0, 2);

         this.p1ItemMessage.setVisible(true);
         this.p2ItemMessage.setVisible(true);
         this.p3ItemMessage.setVisible(true);
         this.p4ItemMessage.setVisible(false);
         this.p5ItemMessage.setVisible(false);
      }
      else if (StartController.globalNumberOfPlayer == 4) {
         p1Name.setText(sc.getList().get(0).getPlayerName());
         p1Tname.setText(sc.getList().get(0).getPlayerName());
         p1BettingAmount.setText("$ " + Integer.toString(sc.getList().get(0).getPlayerBettingAmount()));
         GamePlay gp1 = new GamePlay();

         if (this.p1PoliceFrozen) {
            gp1.setSelectedCharacter("police");
            this.p1Police.setVisible(true);
         }
         else {
            gp1.setSelectedCharacter(sc.getList().get(0).getPlayerCharacter().toLowerCase());
         }

         Image imgP1 = gp1.getSelectedCharacter();
         p1 = new ImageView(imgP1);
         chracterGrid.add(p1, 0, 0);

         p2Name.setText(sc.getList().get(1).getPlayerName());
         p2Tname.setText(sc.getList().get(1).getPlayerName());
         p2BettingAmount.setText("$ " + Integer.toString(sc.getList().get(1).getPlayerBettingAmount()));
         GamePlay gp2 = new GamePlay();

         if (this.p2PoliceFrozen) {
            gp2.setSelectedCharacter("police");
            this.p2Police.setVisible(true);
         }
         else {
            gp2.setSelectedCharacter(sc.getList().get(1).getPlayerCharacter().toLowerCase());
         }

         Image imgP2 = gp2.getSelectedCharacter();
         p2 = new ImageView(imgP2);
         chracterGrid.add(p2, 0, 1);

         p3Name.setText(sc.getList().get(2).getPlayerName());
         p3Tname.setText(sc.getList().get(2).getPlayerName());
         p3BettingAmount.setText("$ " + Integer.toString(sc.getList().get(2).getPlayerBettingAmount()));
         GamePlay gp3 = new GamePlay();
         if (this.p3PoliceFrozen) {
            gp3.setSelectedCharacter("police");
            this.p3Police.setVisible(true);
         }
         else {
            gp3.setSelectedCharacter(sc.getList().get(2).getPlayerCharacter().toLowerCase());
         }

         Image imgP3 = gp3.getSelectedCharacter();
         p3 = new ImageView(imgP3);
         chracterGrid.add(p3, 0, 2);

         p4Name.setText(sc.getList().get(3).getPlayerName());
         p4Tname.setText(sc.getList().get(3).getPlayerName());
         p4BettingAmount.setText("$ " + Integer.toString(sc.getList().get(3).getPlayerBettingAmount()));
         GamePlay gp4 = new GamePlay();
         if (this.p4PoliceFrozen) {
            gp4.setSelectedCharacter("police");
            this.p4Police.setVisible(true);
         }
         else {
            gp4.setSelectedCharacter(sc.getList().get(3).getPlayerCharacter().toLowerCase());
         }
         Image imgP4 = gp4.getSelectedCharacter();
         p4 = new ImageView(imgP4);
         chracterGrid.add(p4, 0, 3);

         this.p1ItemMessage.setVisible(true);
         this.p2ItemMessage.setVisible(true);
         this.p3ItemMessage.setVisible(true);
         this.p4ItemMessage.setVisible(true);
         this.p5ItemMessage.setVisible(false);
      }
      else if (StartController.globalNumberOfPlayer == 5) {
         p1Name.setText(sc.getList().get(0).getPlayerName());
         p1Tname.setText(sc.getList().get(0).getPlayerName());
         p1BettingAmount.setText("$ " + Integer.toString(sc.getList().get(0).getPlayerBettingAmount()));
         GamePlay gp1 = new GamePlay();
         if (this.p1PoliceFrozen) {
            gp1.setSelectedCharacter("police");
            this.p1Police.setVisible(true);
         }
         else {
            gp1.setSelectedCharacter(sc.getList().get(0).getPlayerCharacter().toLowerCase());
         }
         Image imgP1 = gp1.getSelectedCharacter();
         p1 = new ImageView(imgP1);
         chracterGrid.add(p1, 0, 0);

         p2Name.setText(sc.getList().get(1).getPlayerName());
         p2Tname.setText(sc.getList().get(1).getPlayerName());
         p2BettingAmount.setText("$ " + Integer.toString(sc.getList().get(1).getPlayerBettingAmount()));
         GamePlay gp2 = new GamePlay();
         if (this.p2PoliceFrozen) {
            gp2.setSelectedCharacter("police");
            this.p2Police.setVisible(true);
         }
         else {
            gp2.setSelectedCharacter(sc.getList().get(1).getPlayerCharacter().toLowerCase());
         }
         Image imgP2 = gp2.getSelectedCharacter();
         p2 = new ImageView(imgP2);
         chracterGrid.add(p2, 0, 1);

         p3Name.setText(sc.getList().get(2).getPlayerName());
         p3Tname.setText(sc.getList().get(2).getPlayerName());
         p3BettingAmount.setText("$ " + Integer.toString(sc.getList().get(2).getPlayerBettingAmount()));
         GamePlay gp3 = new GamePlay();
         if (this.p3PoliceFrozen) {
            gp3.setSelectedCharacter("police");
            this.p3Police.setVisible(true);
         }
         else {
            gp3.setSelectedCharacter(sc.getList().get(2).getPlayerCharacter().toLowerCase());
         }
         Image imgP3 = gp3.getSelectedCharacter();
         p3 = new ImageView(imgP3);
         chracterGrid.add(p3, 0, 2);

         p4Name.setText(sc.getList().get(3).getPlayerName());
         p4Tname.setText(sc.getList().get(3).getPlayerName());
         p4BettingAmount.setText("$ " + Integer.toString(sc.getList().get(3).getPlayerBettingAmount()));
         GamePlay gp4 = new GamePlay();
         if (this.p4PoliceFrozen) {
            gp4.setSelectedCharacter("police");
            this.p4Police.setVisible(true);
         }
         else {
            gp4.setSelectedCharacter(sc.getList().get(3).getPlayerCharacter().toLowerCase());
         }
         Image imgP4 = gp4.getSelectedCharacter();
         p4 = new ImageView(imgP4);
         chracterGrid.add(p4, 0, 3);

         p5Name.setText(sc.getList().get(4).getPlayerName());
         p5Tname.setText(sc.getList().get(4).getPlayerName());
         p5BettingAmount.setText("$ " + Integer.toString(sc.getList().get(4).getPlayerBettingAmount()));
         GamePlay gp5 = new GamePlay();
         if (this.p5PoliceFrozen) {
            gp5.setSelectedCharacter("police");
            this.p5Police.setVisible(true);
         }
         else {
            gp5.setSelectedCharacter(sc.getList().get(4).getPlayerCharacter().toLowerCase());
         }
         Image imgP5 = gp5.getSelectedCharacter();
         p5 = new ImageView(imgP5);
         chracterGrid.add(p5, 0, 4);
         chracterGrid.setPadding(new Insets(0, 0, 20, 0));

         this.p1ItemMessage.setVisible(true);
         this.p2ItemMessage.setVisible(true);
         this.p3ItemMessage.setVisible(true);
         this.p4ItemMessage.setVisible(true);
         this.p5ItemMessage.setVisible(true);
      }
      set.setDisable(true);
   }

   @FXML
   public void startRacing ()
   {
      this.turnOnSiren();
      StartController sc = new StartController();
      int numberOfPlayer = sc.getList().size();
      GamePlay gp = new GamePlay(numberOfPlayer);

      startP1Animation();
      startP2Animation();
      startP3Animation();
      startP4Animation();
      startP5Animation();
      start.setDisable(true);
   }

   SequentialTransition sq1;

   public void startP1Animation ()
   {
      TranslateTransition p1Trans1 = new TranslateTransition();
      p1Trans1.setDuration(Duration.seconds(generateRandomSpeed1()));
      p1Trans1.setNode(p1);
      p1Trans1.setFromX(0);
      p1Trans1.setToX(500);

      TranslateTransition p1Trans2 = new TranslateTransition();
      if (this.p1SpeedUp) {
         p1Trans2.setDuration(Duration.seconds(1));
      }
      else {
         p1Trans2.setDuration(Duration.seconds(generateRandomSpeed2()));
      }
      p1Trans2.setNode(p1);

      if (this.p1Transport) {
         p1Trans2.setFromX(600);
         p1Trans2.setToX(900);
      }
      else {
         p1Trans2.setToX(900);
      }

      TranslateTransition p1Trans3 = new TranslateTransition();
      if (!this.p1PoliceFrozen) {
         p1Trans3.setDuration(Duration.seconds(18));
      }
      else {
         p1Trans3.setDuration(Duration.seconds(generateRandomSpeed3()));
      }

      p1Trans3.setNode(p1);
      p1Trans3.setToX(1350);
      sq1 = new SequentialTransition(p1, p1Trans1, p1Trans2, p1Trans3);
      sq1.play();

      if (StartController.globalNumberOfPlayer == 1) {
         sq1.setOnFinished((e) -> {
            this.rank++;
            p1Rank.setText(Integer.toString(this.rank));

            switch (p1Rank.getText()) {
               case "1":
                  p1TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() * 2));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() * 2;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p1TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() / 2 + 1));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(0, new Start(StartController.player.get(0).getPlayerName(),
                                                    StartController.player.get(0).getPlayerCharacter(),
                                                    StartController.player.get(0).getPlayerBettingAmount(),
                                                    StartController.p1TotalAmount));
         });
      }
   }

   SequentialTransition sq2;

   public void startP2Animation ()
   {
      TranslateTransition p2Trans1 = new TranslateTransition();
      p2Trans1.setDuration(Duration.seconds(generateRandomSpeed1()));
      p2Trans1.setNode(p2);
      p2Trans1.setFromX(0);
      p2Trans1.setToX(500);

      TranslateTransition p2Trans2 = new TranslateTransition();
      if (this.p2SpeedUp) {
         p2Trans2.setDuration(Duration.seconds(1));
      }
      else {
         p2Trans2.setDuration(Duration.seconds(generateRandomSpeed2()));
      }
      p2Trans2.setNode(p2);

      if (this.p2Transport) {
         p2Trans2.setFromX(600);
         p2Trans2.setToX(900);
      }
      else {
         p2Trans2.setToX(900);
      }

      TranslateTransition p2Trans3 = new TranslateTransition();
      if (!this.p2PoliceFrozen) {
         p2Trans3.setDuration(Duration.seconds(18));
      }
      else {
         p2Trans3.setDuration(Duration.seconds(generateRandomSpeed3()));
      }

      p2Trans3.setNode(p2);
      p2Trans3.setToX(1350);
      sq2 = new SequentialTransition(p2, p2Trans1, p2Trans2, p2Trans3);
      sq2.play();

      if (StartController.globalNumberOfPlayer == 1) {
         sq2.setOnFinished((e) -> {
            this.rank++;
            p2Rank.setText(Integer.toString(this.rank));

            switch (p2Rank.getText()) {
               case "1":
                  p2TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() * 2));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() * 2;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p2TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() / 2 + 1));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(1, new Start(StartController.player.get(1).getPlayerName(),
                                                    StartController.player.get(1).getPlayerCharacter(),
                                                    StartController.player.get(1).getPlayerBettingAmount(),
                                                    StartController.p2TotalAmount));
         });
      }

      if (StartController.globalNumberOfPlayer >= 2) {
         sq1.setOnFinished((e) -> {
            this.rank++;
            p1Rank.setText(Integer.toString(this.rank));
            switch (p1Rank.getText()) {
               case "1":
                  p1TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() * 2));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() * 2;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p1TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() / 2 + 1));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(0, new Start(StartController.player.get(0).getPlayerName(),
                                                    StartController.player.get(0).getPlayerCharacter(),
                                                    StartController.player.get(0).getPlayerBettingAmount(),
                                                    StartController.p1TotalAmount));
         });

         sq2.setOnFinished((e) -> {
            this.rank++;
            p2Rank.setText(Integer.toString(this.rank));

            switch (p2Rank.getText()) {
               case "1":
                  p2TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() * 2));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() * 2;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p2TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() / 2 + 1));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(1, new Start(StartController.player.get(1).getPlayerName(),
                                                    StartController.player.get(1).getPlayerCharacter(),
                                                    StartController.player.get(1).getPlayerBettingAmount(),
                                                    StartController.p2TotalAmount));
         });
      }
   }

   SequentialTransition sq3;

   public void startP3Animation ()
   {
      TranslateTransition p3Trans1 = new TranslateTransition();
      p3Trans1.setDuration(Duration.seconds(generateRandomSpeed1()));
      p3Trans1.setNode(p3);
      p3Trans1.setFromX(0);
      p3Trans1.setToX(500);

      TranslateTransition p3Trans2 = new TranslateTransition();
      if (this.p3SpeedUp) {
         p3Trans2.setDuration(Duration.seconds(1));
      }
      else {
         p3Trans2.setDuration(Duration.seconds(generateRandomSpeed2()));
      }
      p3Trans2.setNode(p3);

      if (this.p3Transport) {
         p3Trans2.setFromX(600);
         p3Trans2.setToX(900);
      }
      else {
         p3Trans2.setToX(900);
      }

      TranslateTransition p3Trans3 = new TranslateTransition();
      if (!this.p3PoliceFrozen) {
         p3Trans3.setDuration(Duration.seconds(18));
      }
      else {
         p3Trans3.setDuration(Duration.seconds(generateRandomSpeed3()));
      }

      p3Trans3.setNode(p3);
      p3Trans3.setToX(1350);
      sq3 = new SequentialTransition(p3, p3Trans1, p3Trans2, p3Trans3);
      sq3.play();

      if (StartController.globalNumberOfPlayer >= 3) {
         sq1.setOnFinished((e) -> {
            this.rank++;
            p1Rank.setText(Integer.toString(this.rank));

            switch (p1Rank.getText()) {
               case "1":
                  p1TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() * 2));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() * 2;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p1TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() / 2 + 1));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "3":
                  p1TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() / 2 + 1));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(0, new Start(StartController.player.get(0).getPlayerName(),
                                                    StartController.player.get(0).getPlayerCharacter(),
                                                    StartController.player.get(0).getPlayerBettingAmount(),
                                                    StartController.p1TotalAmount));
         });

         sq2.setOnFinished((e) -> {
            this.rank++;
            p2Rank.setText(Integer.toString(this.rank));

            switch (p2Rank.getText()) {
               case "1":
                  p2TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() * 2));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() * 2;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p2TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() / 2 + 1));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "3":
                  p2TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() / 2 + 1));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(1, new Start(StartController.player.get(1).getPlayerName(),
                                                    StartController.player.get(1).getPlayerCharacter(),
                                                    StartController.player.get(1).getPlayerBettingAmount(),
                                                    StartController.p2TotalAmount));
         });

         sq3.setOnFinished((e) -> {
            this.rank++;
            p3Rank.setText(Integer.toString(this.rank));

            switch (p3Rank.getText()) {
               case "1":
                  p3TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() * 2));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() * 2;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p3TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() / 2 + 1));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "3":
                  p3TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() / 2 + 1));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(2, new Start(StartController.player.get(2).getPlayerName(),
                                                    StartController.player.get(2).getPlayerCharacter(),
                                                    StartController.player.get(2).getPlayerBettingAmount(),
                                                    StartController.p3TotalAmount));
         });
      }
   }

   SequentialTransition sq4;

   public void startP4Animation ()
   {
      TranslateTransition p4Trans1 = new TranslateTransition();
      p4Trans1.setDuration(Duration.seconds(generateRandomSpeed1()));
      p4Trans1.setNode(p4);
      p4Trans1.setFromX(0);
      p4Trans1.setToX(500);

      TranslateTransition p4Trans2 = new TranslateTransition();
      if (this.p4SpeedUp) {
         p4Trans2.setDuration(Duration.seconds(1));
      }
      else {
         p4Trans2.setDuration(Duration.seconds(generateRandomSpeed2()));
      }
      p4Trans2.setNode(p4);

      if (this.p4Transport) {
         p4Trans2.setFromX(600);
         p4Trans2.setToX(900);
      }
      else {
         p4Trans2.setToX(900);
      }

      TranslateTransition p4Trans3 = new TranslateTransition();
      if (!this.p4PoliceFrozen) {
         p4Trans3.setDuration(Duration.seconds(18));
      }
      else {
         p4Trans3.setDuration(Duration.seconds(generateRandomSpeed3()));
      }

      p4Trans3.setNode(p4);
      p4Trans3.setToX(1350);
      sq4 = new SequentialTransition(p4, p4Trans1, p4Trans2, p4Trans3);
      sq4.play();

      if (StartController.globalNumberOfPlayer >= 4) {
         sq1.setOnFinished((e) -> {
            this.rank++;
            p1Rank.setText(Integer.toString(this.rank));

            switch (p1Rank.getText()) {
               case "1":
                  p1TotalAmountMessage.setText("x 4 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() * 4));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() * 4;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p1TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() * 2));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() * 2;
                  break;
               case "3":
                  p1TotalAmountMessage.setText("/ 2= $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() / 2 + 1));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "4":
                  p1TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() / 2 + 1));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() / 2 + 1;
                  break;
            }

            StartController.player.set(0, new Start(StartController.player.get(0).getPlayerName(),
                                                    StartController.player.get(0).getPlayerCharacter(),
                                                    StartController.player.get(0).getPlayerBettingAmount(),
                                                    StartController.p1TotalAmount));
         });

         sq2.setOnFinished((e) -> {
            this.rank++;
            p2Rank.setText(Integer.toString(this.rank));

            switch (p2Rank.getText()) {
               case "1":
                  p2TotalAmountMessage.setText("x 4 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() * 4));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() * 4;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p2TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() * 2));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() * 2;
                  break;
               case "3":
                  p2TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() / 2 + 1));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "4":
                  p2TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() / 2 + 1));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(1, new Start(StartController.player.get(1).getPlayerName(),
                                                    StartController.player.get(1).getPlayerCharacter(),
                                                    StartController.player.get(1).getPlayerBettingAmount(),
                                                    StartController.p2TotalAmount));
         });

         sq3.setOnFinished((e) -> {
            this.rank++;
            p3Rank.setText(Integer.toString(this.rank));

            switch (p3Rank.getText()) {
               case "1":
                  p3TotalAmountMessage.setText("x 4 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() * 4));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() * 4;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p3TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() * 2));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() * 2;
                  break;
               case "3":
                  p3TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() / 2 + 1));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "4":
                  p3TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() / 2 + 1));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(2, new Start(StartController.player.get(2).getPlayerName(),
                                                    StartController.player.get(2).getPlayerCharacter(),
                                                    StartController.player.get(2).getPlayerBettingAmount(),
                                                    StartController.p3TotalAmount));
         });

         sq4.setOnFinished((e) -> {
            this.rank++;
            p4Rank.setText(Integer.toString(this.rank));

            switch (p4Rank.getText()) {
               case "1":
                  p4TotalAmountMessage.setText("x 4 = $ " + Integer.toString(StartController.player.get(3).getPlayerBettingAmount() * 4));
                  StartController.p4TotalAmount = StartController.player.get(3).getPlayerBettingAmount() * 4;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p4TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(3).getPlayerBettingAmount() * 2));
                  StartController.p4TotalAmount = StartController.player.get(3).getPlayerBettingAmount() * 2;
                  break;
               case "3":
                  p4TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(3).getPlayerBettingAmount() / 2 + 1));
                  StartController.p4TotalAmount = StartController.player.get(3).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "4":
                  p4TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(3).getPlayerBettingAmount() / 2 + 1));
                  StartController.p4TotalAmount = StartController.player.get(3).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(3, new Start(StartController.player.get(3).getPlayerName(),
                                                    StartController.player.get(3).getPlayerCharacter(),
                                                    StartController.player.get(3).getPlayerBettingAmount(),
                                                    StartController.p4TotalAmount));
         });
      }
   }

   SequentialTransition sq5;

   public void startP5Animation ()
   {
      TranslateTransition p5Trans1 = new TranslateTransition();
      p5Trans1.setDuration(Duration.seconds(generateRandomSpeed1()));
      p5Trans1.setNode(p5);
      p5Trans1.setFromX(0);
      p5Trans1.setToX(500);

      TranslateTransition p5Trans2 = new TranslateTransition();
      if (this.p5SpeedUp) {
         p5Trans2.setDuration(Duration.seconds(1));
      }
      else {
         p5Trans2.setDuration(Duration.seconds(generateRandomSpeed2()));
      }
      p5Trans2.setNode(p5);

      if (this.p5Transport) {
         p5Trans2.setFromX(600);
         p5Trans2.setToX(900);
      }
      else {
         p5Trans2.setToX(900);
      }

      TranslateTransition p5Trans3 = new TranslateTransition();
      if (!this.p5PoliceFrozen) {
         p5Trans3.setDuration(Duration.seconds(18));
      }
      else {
         p5Trans3.setDuration(Duration.seconds(generateRandomSpeed3()));
      }
      p5Trans3.setNode(p5);
      p5Trans3.setToX(1350);

      sq5 = new SequentialTransition(p5, p5Trans1, p5Trans2, p5Trans3);
      sq5.play();

      if (StartController.globalNumberOfPlayer >= 5) {
         sq1.setOnFinished((e) -> {
            this.rank++;
            p1Rank.setText(Integer.toString(this.rank));

            switch (p1Rank.getText()) {
               case "1":
                  p1TotalAmountMessage.setText("x 5 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() * 5));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() * 5;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p1TotalAmountMessage.setText("x 3 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() * 3));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() * 3;
                  break;
               case "3":
                  p1TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() * 2));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() * 2;
                  break;
               case "4":
                  p1TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() / 2 + 1));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "5":
                  p1TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(0).getPlayerBettingAmount() / 2 + 1));
                  StartController.p1TotalAmount = StartController.player.get(0).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(0, new Start(StartController.player.get(0).getPlayerName(),
                                                    StartController.player.get(0).getPlayerCharacter(),
                                                    StartController.player.get(0).getPlayerBettingAmount(),
                                                    StartController.p1TotalAmount));
         });

         sq2.setOnFinished((e) -> {
            this.rank++;
            p2Rank.setText(Integer.toString(this.rank));

            switch (p2Rank.getText()) {
               case "1":
                  p2TotalAmountMessage.setText("x 5 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() * 5));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() * 5;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p2TotalAmountMessage.setText("x 3 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() * 3));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() * 3;
                  break;
               case "3":
                  p2TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() * 2));
                  StartController.p2TotalAmount = StartController.player.get(1).getPlayerBettingAmount() * 2;
                  break;
               case "4":
                  p2TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() / 2 + 1));
                  StartController.p2TotalAmount = StartController.player.get(2).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "5":
                  p2TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(1).getPlayerBettingAmount() / 2 + 1));
                  StartController.p2TotalAmount = StartController.player.get(2).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(1, new Start(StartController.player.get(1).getPlayerName(),
                                                    StartController.player.get(1).getPlayerCharacter(),
                                                    StartController.player.get(1).getPlayerBettingAmount(),
                                                    StartController.p2TotalAmount));
         });

         sq3.setOnFinished((e) -> {
            this.rank++;
            p3Rank.setText(Integer.toString(this.rank));

            switch (p3Rank.getText()) {
               case "1":
                  p3TotalAmountMessage.setText("x 5 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() * 5));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() * 5;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p3TotalAmountMessage.setText("x 3 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() * 3));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() * 3;
                  break;
               case "3":
                  p3TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() * 2));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() * 2;
                  break;
               case "4":
                  p3TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() / 2 + 1));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "5":
                  p3TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(2).getPlayerBettingAmount() / 2 + 1));
                  StartController.p3TotalAmount = StartController.player.get(2).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(2, new Start(StartController.player.get(2).getPlayerName(),
                                                    StartController.player.get(2).getPlayerCharacter(),
                                                    StartController.player.get(2).getPlayerBettingAmount(),
                                                    StartController.p3TotalAmount));
         });

         sq4.setOnFinished((e) -> {
            this.rank++;
            p4Rank.setText(Integer.toString(this.rank));

            switch (p4Rank.getText()) {
               case "1":
                  p4TotalAmountMessage.setText("x 5 = $ " + Integer.toString(StartController.player.get(3).getPlayerBettingAmount() * 5));
                  StartController.p4TotalAmount = StartController.player.get(3).getPlayerBettingAmount() * 5;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p4TotalAmountMessage.setText("x 3 = $ " + Integer.toString(StartController.player.get(3).getPlayerBettingAmount() * 3));
                  StartController.p4TotalAmount = StartController.player.get(3).getPlayerBettingAmount() * 3;
                  break;
               case "3":
                  p4TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(3).getPlayerBettingAmount() * 2));
                  StartController.p4TotalAmount = StartController.player.get(3).getPlayerBettingAmount() * 2;
                  break;
               case "4":
                  p4TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(3).getPlayerBettingAmount() / 2 + 1));
                  StartController.p4TotalAmount = StartController.player.get(3).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "5":
                  p4TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(3).getPlayerBettingAmount() / 2 + 1));
                  StartController.p4TotalAmount = StartController.player.get(3).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(3, new Start(StartController.player.get(3).getPlayerName(),
                                                    StartController.player.get(3).getPlayerCharacter(),
                                                    StartController.player.get(3).getPlayerBettingAmount(),
                                                    StartController.p4TotalAmount));
         });

         sq5.setOnFinished((e) -> {
            this.rank++;
            p5Rank.setText(Integer.toString(this.rank));

            switch (p5Rank.getText()) {
               case "1":
                  p5TotalAmountMessage.setText("x 5 = $ " + Integer.toString(StartController.player.get(4).getPlayerBettingAmount() * 5));
                  StartController.p5TotalAmount = StartController.player.get(4).getPlayerBettingAmount() * 5;
                  this.turnOnWinnerMusic();
                  break;
               case "2":
                  p5TotalAmountMessage.setText("x 3 = $ " + Integer.toString(StartController.player.get(4).getPlayerBettingAmount() * 3));
                  StartController.p5TotalAmount = StartController.player.get(4).getPlayerBettingAmount() * 3;
                  break;
               case "3":
                  p5TotalAmountMessage.setText("x 2 = $ " + Integer.toString(StartController.player.get(4).getPlayerBettingAmount() * 2));
                  StartController.p5TotalAmount = StartController.player.get(4).getPlayerBettingAmount() * 2;
                  break;
               case "4":
                  p5TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(4).getPlayerBettingAmount() / 2 + 1));
                  StartController.p5TotalAmount = StartController.player.get(4).getPlayerBettingAmount() / 2 + 1;
                  break;
               case "5":
                  p5TotalAmountMessage.setText("/ 2 = $ " + Integer.toString(StartController.player.get(4).getPlayerBettingAmount() / 2 + 1));
                  StartController.p5TotalAmount = StartController.player.get(4).getPlayerBettingAmount() / 2 + 1;
                  break;
            }
            StartController.player.set(4, new Start(StartController.player.get(4).getPlayerName(),
                                                    StartController.player.get(4).getPlayerCharacter(),
                                                    StartController.player.get(4).getPlayerBettingAmount(),
                                                    StartController.p5TotalAmount));
         });
      }
   }

   public void setAlert (String message)
   {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setHeaderText("Cannot leave before finish the race : (");
      alert.show();
   }

   public int generateRandomSpeed1 ()
   {
      Random rnd = new Random();
      int rndSpeed = rnd.nextInt(7) + 10;
      return rndSpeed;
   }

   public int generateRandomSpeed2 ()
   {
      Random rnd = new Random();
      int rndSpeed = rnd.nextInt(7) + 10;
      return rndSpeed;
   }

   public double generateRandomSpeed3 ()
   {
      Random rnd = new Random();
      int rndSpeed = rnd.nextInt(3) + 3;
      return rndSpeed;
   }

   @FXML
   public void SaveRecord (ActionEvent event) throws IOException
   {
      if (this.rank < StartController.globalNumberOfPlayer) {
         this.setAlert("Cannot stop the game : ( ");
      }
      else {
         this.turnOffFanfare();
         this.turnOffSiren();
         this.turnOffWinnerMusic();
         TheFinalGambleHero.show3();
      }

      this.appendPlayers();
   }

   public void appendPlayers ()
   {
      try {
         File file = new File("record.txt");
         if (!file.exists()) {
            file.createNewFile();
         }
         FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
         BufferedWriter bw = new BufferedWriter(fw);

         String output = "";
         for (int i = 0; i < StartController.player.size(); i++) {
            bw.write(StartController.player.get(i).toString());
            bw.newLine();
         }

         bw.close();
         fw.close();
      }
      catch (IOException e) {
         System.out.println(e);
      }
   }

}
