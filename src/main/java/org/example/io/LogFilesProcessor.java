package org.example.io;

import java.io.*;

public class LogFilesProcessor {
    public static void main(String[] args) {

        File  folder= new File("src/main/resources/logFiles");
        File[] listOfFiles= folder.listFiles();

        if(listOfFiles==null){
            System.out.println("Folder not found or empty");
            return;
        }
        for(File file:listOfFiles){
            if(file.isFile() && file.getName().endsWith(".log")){
                System.out.println("Processing log file: "+ file.getName());
                procesLogFile(file);
            }
        }



    }

    private static void procesLogFile(File file) {
//        String inputPath="src/main/resources/app.log";

        try( BufferedReader br=new BufferedReader(new FileReader(file));
             BufferedWriter bw=new BufferedWriter(new FileWriter("src/main/resources/errors.log",true))) {
            String line;
            while((line=br.readLine())!=null){

                System.out.println(line);
                if(line.contains("ERROR")){
                    bw.write(line);
                    bw.newLine();
                    System.out.println("Found the error line"+ line);
                }
            }

            System.out.println("================================");
            System.out.println("Log processing completed. Errors written to errors.log");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
