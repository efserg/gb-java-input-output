package ru.gb;


import java.io.File;
import java.io.IOException;

public class App01File {
    public static void main(String[] args) throws IOException {
        // класс File в java.io представляет собой отображение файла
        // (необязательно реально существующего), или директории в java класс
        final File file = new File("C:\\mydirectory\\myfile.txt");
        // в Windows приходится экранировать обратный слеш, т.к. с обратного
        // слеша начинаются управляющие символы (например, \n, \t).

        // Создание нового инстанса типа File не означает, что файл будет
        // загружен в память - переменная file содержит только путь и предоставляет
        // некоторые методы для работы с файловой системой

        // как еще можно создать инстанс файла
        String path = "D:\\mydir";
        String filename = "filename.txt";
        final File file1 = new File(path, filename);

        // не рекомендуется явно указывать разделитель (в системах, отличных от
        // Windows он может быть другим
        String pathToFile = "mydir" + File.separator + "filename.txt";

        // Некоторые методы класса File:

        // Проверка существования файла по указанному пути
        final boolean exists = file.exists();

        // Возвращает имя файла или директории
        final String name = file.getName();

        // Возвращает директорию, в которой хранится данный файл, в зависимости
        // от метода будет возвращен объект типа File или String
        final String parent = file.getParent();
        final File parentFile = file.getParentFile();

        // Проверяет, что объект типа File указывает на директорию, или на файл.
        // (Эта проверка имеет место быть, так как в объект типа File, мы можем
        // записать путь указывающий как на файл, так и на каталог)
        final boolean isDirectory = file.isDirectory();
        final boolean isFile = file.isFile();

        // Возвращает размер файла в байтах
        final long length = file.length();

        // Возвращает список файлов в текущей директории, в зависимости от
        // метода будет возвращен или массив File[], или String[]
        final File[] files = file.listFiles();
        final String[] list = file.list();

        // Удаляет файл по указанному пути.Если File указывает путь на
        // каталог, то удаление выполнится только если этот каталог пуст.
        final boolean isDelete = file.delete();

        // mkdir() создает только один каталог по указанному пути, если на
        // пути к нему не будет хватать промежуточных звеньев (каталогов),
        // то операция не выполнится.
        final boolean mkdir = file.mkdir();

        // mkdirs() создает каталог по указанному пути, если на пути к нему
        // не будет хватать промежуточных звеньев, все эти звенья будут
        // также созданы
        final boolean mkdirs = file.mkdirs();

        // Обход дерева каталогов, начиная с указанной директории
        final App01File app = new App01File();
        app.dirWalker(new File("E:\\workspace\\geek-brains\\gb-java-in-out"));
    }

    private void dirWalker(File file) throws IOException {
        for (File child : file.listFiles()) {
            if (child.isDirectory()) {
                dirWalker(child);
            } else {
                System.out.println(child.getAbsolutePath());
            }
        }
    }
}
