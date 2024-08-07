package file_io_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class WriteCollectionOfLines {
    public static void main(String[] args) {
        Path path= Paths.get("src/main/java/file_io_1/test.txt");
        List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
        try{
            Files.write(path,lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
