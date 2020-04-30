package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        try {
            Files.lines(Paths.get(args[0]))
                    .map(FileHandler::translateToEng)
//                    .map(FileHandler::translateToRus)
                    .map(FileHandler::upperCase)
//                    .map(FileHandler::lowerCase)
//                    .forEach(System.out::println);
                    .forEach(FileHandler::writeToFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
//            while (reader.ready()) {
//                String str = reader.readLine();
//                writer.write(str);
//                if (reader.ready()) {
//                    writer.newLine();
//                }
//            }
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//
//        }

//        int n = 10;
//        try {
//            n = Integer.parseInt(args[0]);
//        } catch (Exception e) {
//
//        }
//
//
//        Random rng = new Random();
//
//        for (
//                int i = 0;
//                i < n - 1; i++) {
//            System.out.print(rng.nextInt(100) + " ");
//        }
//        System.out.println("Hello World!");
    }
}
