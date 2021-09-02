package ru.gb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App02Nio {
    // В java 1.4 появился еще один пакет для чтения / записи потоков байт -
    // java.nio (New io). Существенные обновления были добавлены в 1.7
    // Java NIO не заменяет стандартный IO, а предлагает немного другой
    // подход к обработке данных. NIO предлагает неблокирующий (асинхронный)
    // ввод-вывод, в отличии от IO, где эти операции являются блокирующими
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get("mydir1", "mydir2", "filename.txt");
        // Класс Path содержит большое количество методов для работы
        // с файловой системой
//        path. //

        // Можно переписать предыдущий пример таким образом
        final Path start = Paths.get("E:", "workspace", "geek-brains", "gb-java-in-out");
        List<Path> result;
        try (Stream<Path> walk = Files.walk(start)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        result.forEach(System.out::println);

        // Класс Files предоставляет много методов для работы с файловой системой
        Files.delete(path);
        final boolean deleteIfExists = Files.deleteIfExists(path);
        final boolean exists = Files.exists(path);
        final Path move = Files.move(path, path);
        // etc...
    }

}
