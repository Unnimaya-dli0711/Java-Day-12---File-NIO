package file_io_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFile {
    public static void main(String[] args) {
        String currentPath="src/main/java/file_io_1/current.txt";
        Path path= Paths.get(currentPath);
        try{
            Files.delete(path);
            System.out.println("File Deleted");
        }catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
