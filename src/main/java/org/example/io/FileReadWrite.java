package org.example.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.*;


public class FileReadWrite
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException {

//        Path path= Paths.get("PaymentReciept.png");
//
        try(FileInputStream fis=new FileInputStream("./PaymentReciept.png"); FileOutputStream fos=new FileOutputStream("PaymentRecieptout.png")){
            int byteData;

            while((byteData=fis.read())!=-1){
                System.out.println(byteData);
                fos.write(byteData);
            }

        }catch(IOException fileNotFoundException){
            System.out.println("File not found");
        }



    }


}
