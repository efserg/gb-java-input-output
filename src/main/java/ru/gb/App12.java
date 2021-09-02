package ru.gb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App12 {
    public static void main(String[] args) {
        scannerVsBufferedReader();
        System.exit(0);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("demo.txt"))) {
            for (int i = 0; i < 20; i++) {
                writer.write("Java\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("demo.txt"))) {
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void scannerVsBufferedReader() {
        try {
            long time;
            time = System.currentTimeMillis();
            BufferedReader br = new BufferedReader(new FileReader("123.txt"));
            while (br.readLine() != null) ;
            br.close();
            System.out.println(System.currentTimeMillis() - time);

            time = System.currentTimeMillis();
            Scanner sc = new Scanner(new FileReader("123.txt"));
            while (sc.hasNext()) {
                sc.nextLine();
            }
            sc.close();
            System.out.println(System.currentTimeMillis() - time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
