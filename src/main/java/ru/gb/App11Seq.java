package ru.gb;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class App11Seq {
    public static void main(String[] args) {
        try (SequenceInputStream seq = new SequenceInputStream(new FileInputStream("1.txt"), new FileInputStream("2.txt"));
             FileOutputStream out = new FileOutputStream("out.txt")) {
            int x;
            while ((x = seq.read()) != -1) {
                out.write(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
