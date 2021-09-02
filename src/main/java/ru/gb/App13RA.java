package ru.gb;

import java.io.IOException;
import java.io.RandomAccessFile;

public class App13RA {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("demo.txt", "r")) {
            raf.seek(2);
            System.out.println((char) raf.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// Содержимое файла demo.txt: "123456789"
// Результат: 3
}
