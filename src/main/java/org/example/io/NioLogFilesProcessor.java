package org.example.io;

import java.io.File;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class NioLogFilesProcessor {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/logfiles/");

        File file = new File(path.toAbsolutePath().toString());

        java.io.File[] files = file.listFiles();

        for (java.io.File file1 : files) {

            if (file1.isFile() && file1.getName().endsWith(".log")) {
                System.out.println("Processing log file: " + file1.getName());
            }
        }


    }
}
