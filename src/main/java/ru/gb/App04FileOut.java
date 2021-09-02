package ru.gb;

import java.io.FileOutputStream;
import java.io.IOException;

public class App04FileOut {
    public static void main(String[] args) {
        // конструкторы
        // FileOutputStream(File file)
        // FileOutputStream(File file, boolean append)
        // FileOutputStream(String name)
        // FileOutputStream(String name, boolean append)

        byte[] outData = "Java".getBytes();
        try (FileOutputStream out = new FileOutputStream("demo.txt")) {
            out.write(outData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // можно писать побайтово, но это будет медленнее
        try (FileOutputStream out = new FileOutputStream("demo.txt")) {
            for (byte outDatum : outData) {
                out.write(outDatum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
