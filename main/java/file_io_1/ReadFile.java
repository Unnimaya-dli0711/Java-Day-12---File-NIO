package file_io_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        Path path=Paths.get("src/main/java/file_io_1/file.txt");
        Stream<String> stream=Files.lines(path);
//        List<String>stringList=stream.collect(Collectors.toList());
//        for (String string:stringList){
//            System.out.println(string);
//        }
        stream.forEach(System.out::println);
    }
}
