package file_io_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    public static void main(String[] args) {
        String fileName="src/main/java/file_io_1/test.txt";
        String copyFileName="src/main/java/file_io_1/destination.txt";
        Path sourcePath= Paths.get(fileName);
        Path destination=Paths.get(copyFileName);
        try{
            Files.copy(sourcePath,destination, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
