import com.github.authorfu.lrcparser.LrcParser;
import com.github.authorfu.lrcparser.parser.Sentence;
import javazoom.jl.player.Player;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;

public class App {
     private static final String SONG_PATH = "src/assets/Kiss-I_Was_Made_For_Lovin'_You/Kiss-I_Was_Made_For_Lovin'_You.mp3";
     private static final String LRC_PATH = "src\\assets\\Kiss-I_Was_Made_For_Lovin'_You\\Kiss-I_Was_Made_For_Lovin'_You (2).lrc";
     private static final float speed = 1;

     public static void main(String[] args) throws InterruptedException {
          try (BufferedReader reader = Files.newBufferedReader(Path.of(LRC_PATH), StandardCharsets.UTF_8)) {

               ArrayList<Sentence> sentences = LrcParser.create(reader).findAllSentences(-1, -1);

               playM(SONG_PATH);
               Thread.sleep(Math.abs(sentences.get(0).getFromTime()));
               writeLRC(sentences);

          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     public static void playM(String path) {
          try {
               Player player = new Player(new FileInputStream(path));
               Thread musicThread = new Thread(() -> {
                    try {
                         player.play();
                    } catch (Exception e) {
                         e.printStackTrace();
                    }
               });

               musicThread.start();
          } catch (Exception e) {
               e.printStackTrace();
          }
     }

     public static void writeLRC(ArrayList<Sentence> sentences) {
          long char_time;
          long sentence_time;
          char[] char_array;
          for (Sentence s : sentences) {
               sentence_time = Math.abs(s.getDuring());
               char_array = s.getContent().toCharArray();
               if(char_array.length != 0) {
                    char_time = sentence_time / s.getContent().toCharArray().length;
                    for (char c : s.getContent().toCharArray()) {
                         System.out.print(c);
                         try {
                              Thread.sleep(Math.abs(char_time));
                         } catch (InterruptedException e) {
                              Thread.currentThread().interrupt();
                         }
                    }
               }
               else{
                    char_time = sentence_time / 3;
                    for (int i = 1; i <=3; i++){
                         System.out.print(".");
                         try {
                              Thread.sleep(Math.abs(char_time));
                         } catch (InterruptedException e) {
                              Thread.currentThread().interrupt();
                         }
                    }
               }
               
               System.out.print("\n");
          }

          // for (Sentence s : sentences) {
          // System.out.println(s.getContent() + " - " + s.getDuring());
          // try {
          // Thread.sleep(s.getDuring());
          // } catch (InterruptedException e) {
          // Thread.currentThread().interrupt();
          // }
          // }
     }
}