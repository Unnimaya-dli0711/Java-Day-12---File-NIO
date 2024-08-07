package file_io_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckExists {
    public static void main(String[] args) {
        String file="src/main/java/file_io_1/sample.txt";
        Path path= Paths.get(file);
        try{
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("File Created");
            }else {
                System.out.println("File exists");
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
