package ru.gb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class App03Byte {
    public static void main(String[] args) {
        // чтение из байтового массива
        byte[] arrIn = {65, 66, 67, -1, -2, -3};
        ByteArrayInputStream in = new ByteArrayInputStream(arrIn);
        int x;
        while ((x = in.read()) != -1) {
            System.out.print(x + " ");
        }

        System.out.println();
        // чтение в массив
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(10);
        out.write(11);
        byte[] arrOut = out.toByteArray();
        System.out.println(Arrays.toString(arrOut));
    }
}
