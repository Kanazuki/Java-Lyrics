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

     private static final String SONG_PATH = "src/GoldZoro-I_kissed_a_girl_(Hardstyle).mp3";
     private static final String LRC_PATH = "src/GoldZoro-I_kissed_a_girl_(Hardstyle).lrc";

     public static void main(String[] args) throws InterruptedException {
          try (BufferedReader reader = Files.newBufferedReader(Path.of(LRC_PATH), StandardCharsets.UTF_8)) {

               ArrayList<Sentence> sentences = LrcParser.create(reader).findAllSentences(-1, -1);

               playM(SONG_PATH);
               Thread.sleep(sentences.get(0).getFromTime());
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
          for (Sentence s : sentences) {
               System.out.println(s.getContent() + " - " + s.getDuring());
               try {
                    Thread.sleep(s.getDuring());
               } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
               }
          }
     }
}