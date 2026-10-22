//Lyrics synchronized with "I Was Made For Lovin' You" by KISS

public class App {
     public static void main(String[] args) throws Exception {
          String[] lines = {
               "Mmm, yeah",
               "Ha",

               "Do, do, do, do, do, do, do, do, do",
               "Do, do, do, do, do, do, do",
               "Do, do, do, do, do, do, do, do, do",
               "Do, do, do, do, do, do, do",

               "Tonight",
               "I wanna give it all to you",
               "In the darkness",
               "There's so much I wanna do",
               "And tonight",
               "I wanna lay it at your feet",
               "'Cause, girl, I was made for you",
               "And, girl, you were made for me",

               "I was made for lovin' you, baby",
               "You were made for lovin' me",
               "And I can't get enough of you, baby",
               "Can you get enough of me?",

               "Tonight",
               "I wanna see it in your eyes",
               "Feel the magic",
               "There's something that drives me wild",
               "And tonight",
               "We're gonna make it all come true",
               "'Cause, girl, you were made for me",
               "And, girl, I was made for you",

               "I was made for lovin' you, baby",
               "You were made for lovin' me",
               "And I can't get enough of you, baby",
               "Can you get enough of me?",
               "I was made for lovin' you, baby",
               "You were made for lovin' me",
               "And I can give it all to you, baby",
               "Can you give it all to me?",

               "Oh, woah, can't get enough",
               "Oh, woah, I can't get enough",
               "Oh, woah, I can't get enough",

               "Ha",

               "Do, do, do, do, do, do, do, do, do",
               "Do, do, do, do, do, do, do",
               "Do, do, do, do, do, do, do, do, do",
               "Do, do, do, do, do, do, do",

               "I was made for lovin' you, baby",
               "You were made for lovin' me",
               "And I can't get enough of you, baby",
               "Can you get enough of me?",

               "Oh, I was made",
               "You were made",
               "I can't get enough",
               "No, I can't get enough",

               "I was made for lovin' you, baby",
               "You were made for lovin' me",
               "And I can't get enough of you, baby",
               "Can you get enough of me?",
               "I was made for lovin' you, baby",
               "You were made for lovin' me",
               "And I can't get enough"
          };

          Integer[] delays = {
               2000, 2500, 2000, 3500, 3500, 3500, 3500, 3000, 3000, 3500,
               3500, 3500, 3500, 4000, 4000, 4500, 4500, 4500, 4500, 3000,
               4000, 3500, 3500, 3500, 3500, 4000, 4000, 4500, 4500, 4500,
               4500, 4500, 4500, 4500, 4500, 4000, 4000, 4000, 18000, 3500,
               3500, 3500, 3500, 4500, 4500, 4500, 4500, 3000, 3000, 3000,
               3000, 4500, 4500, 4500, 4500, 4500, 4500
          };  

          String mp3Path = "E:\\Programare\\Java\\Lyrics\\src\\Kiss - I Was Made For Lovin' You.mp3";
               // Play the MP3 file in a separate threadq
          new Thread(() -> {
               try {
                    new ProcessBuilder("cmd", "/c", "start", "\"\"", mp3Path).start();
               } catch (Exception e) {
                    e.printStackTrace();
               }
          }).start();
          
          Thread.sleep(12000); //12s delay to sync with the music before starting to print lyrics

          for (int i = 0; i < lines.length; i++) {
               for (char c : lines[i].toCharArray()) {
                    System.out.print(c);
                    Thread.sleep(50); // Delay between characters (50ms for faster typing effect)
               }
               System.out.println(); // New line after each lyric line
               Thread.sleep(delays[i]); // Delay before the next line
          }
     }
}