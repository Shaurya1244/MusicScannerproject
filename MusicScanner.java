import java.io.File;

public class MusicScanner {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\SHAURYA YADAV\\Music";
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder: " + folderPath);
            return;
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found.");
            return;
        }

        int count = 0;
        for (File file : files) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".mp3")) {
                System.out.println(file.getName());
                count++;
            }
        }

        System.out.println("Total MP3 files: " + count);
    }
}
