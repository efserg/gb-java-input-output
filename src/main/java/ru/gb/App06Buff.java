package ru.gb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class App06Buff {
    public static void main(String[] args) {
        defaultReadVsBuffered();
        System.exit(0);
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream("demo.txt"))) {
            for (int i = 0; i < 1_000_000; i++) {
                out.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream in = new BufferedInputStream(new FileInputStream("demo.txt"))) {
            int x;
            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void defaultReadVsBuffered() {
        String filename = "123.txt";
        StringBuilder sb1 = new StringBuilder("");
        long time0 = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream(filename)) {
            int x;
            do {
                x = in.read();
                sb1.append((char)x);
            } while (x != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Default reading: " + (System.currentTimeMillis() - time0));
        time0 = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder("");
        //try-with-resources
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename))) {
            int x;
            do {
                x = in.read();
                sb2.append((char)x);
            } while (x != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Buffered reading: " + (System.currentTimeMillis() - time0));
    }
}
