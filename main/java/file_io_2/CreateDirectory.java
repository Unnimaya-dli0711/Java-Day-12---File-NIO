package file_io_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateDirectory {
    public static void main(String[] args) {
        Path path= Paths.get("src/main/java/file_io_2/subfolder");
        try{
            Files.createDirectories(path);
            System.out.println("Directories Created");
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
