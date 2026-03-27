package org.example.exceptionhandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Custom Exception
class LogProcessingException extends Exception {
    public LogProcessingException(String message, Throwable cause) {
        super(message, cause); // Links the original exception
    }
}

public class ChainingExample {
    public static void main(String[] args) {
        try {
            readLogFile("invalid_path.log");
        } catch (LogProcessingException e) {
            System.out.println("High-level error: " + e.getMessage());
            System.out.println("Actual root cause: " + e.getCause()); 
            // e.printStackTrace() would show the full "Caused by:" chain
        }
    }

    static void readLogFile(String path) throws LogProcessingException {
        try {
            // Low-level operation
            Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            // CHAINING: Wrap the low-level IOException in our high-level Business Exception
            throw new LogProcessingException("Failed to process the logs for the daily report", e);
        }
    }
}