package com.dmdev.exceptions;
import java.io.*;

public class CheckedAndUncheckedExceptions {
    public static String readFile(String path) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException("Неверный путь");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.readLine();
        } catch (FileNotFoundException e) {
            throw new IOException("Файл не найден", e);
        }
    }

    public static void main(String[] args){
        String filePath = "path/to/your/file.txt";
        try {
            String firstLine = readFile(filePath);
            System.out.println("Первая строка файла: " + firstLine);
        } catch (IllegalArgumentException e) {
            System.out.println("Непроверяемое исключение: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Проверяемое исключение: " + e.getMessage());
        }

    }
}

