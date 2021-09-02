package ru.gb;

import java.io.FileInputStream;
import java.io.IOException;

public class App05FileIn {
    public static void main(String[] args) {
        byte[] buf = new byte[20];

        try (FileInputStream in = new FileInputStream("demo.txt")) {
            int count;
            while ((count = in.read(buf)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print((char) buf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
