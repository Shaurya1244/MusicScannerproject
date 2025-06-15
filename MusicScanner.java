import java.io.File;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.Tag;

public class MusicScanner {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\YourName\\Music"); // Change this path to your music folder
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".mp3")) {
                    try {
                        AudioFile audioFile = AudioFileIO.read(file);
                        Tag tag = audioFile.getTag();

                        String title = tag.getFirst("TITLE");
                        String artist = tag.getFirst("ARTIST");

                        System.out.println("🎵 Title: " + title + " | 🎤 Artist: " + artist);
                    } catch (Exception e) {
                        System.out.println("❌ Cannot read: " + file.getName());
                    }
                }
            }
        }
    }
}
