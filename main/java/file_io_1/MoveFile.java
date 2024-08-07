package file_io_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveFile {
    public static void main(String[] args) {
        String currentPath="src/main/java/file_io_1/current.txt";
        String moveTo="src/main/java/file_io_1/final.txt";
        Path sourcePath= Paths.get(currentPath);
        Path destination=Paths.get(moveTo);
        try{
            Files.copy(sourcePath,destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved successfully.");
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
