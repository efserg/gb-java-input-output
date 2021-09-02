package ru.gb;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class App08Serial {
    private static class Cat implements Serializable {
        private static final long serialVersionUID = 1L;

        private String name;
        private transient Integer age;

        public Cat(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Кот " + name + " в возрасте " + age + " лет";
        }
    }

    public static void main(String[] args) {
        byte[] byteCat = null;
        try (ByteArrayOutputStream barrOut = new ByteArrayOutputStream();
             ObjectOutputStream objOut = new ObjectOutputStream(barrOut)) {
            Cat catOut = new Cat("Барсик", 5);
            objOut.writeObject(catOut);
            byteCat = barrOut.toByteArray();
            System.out.println("Кот до сериализации: " + catOut);
            System.out.println("Вот так он выглядит в байтовом представлении: " + Arrays.toString(byteCat));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ByteArrayInputStream barrIn = new ByteArrayInputStream(byteCat);
             ObjectInputStream objIn = new ObjectInputStream(barrIn)) {
            Cat catIn = (Cat) objIn.readObject();
            System.out.println("А вот такого кота мы восстановили из набора байтов: " + catIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
