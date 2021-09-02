package ru.gb;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Locale;

public class App09Ext {
    private static class Cat implements Externalizable {
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

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(name.toUpperCase());
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            in.readObject();
        }
    }


}
