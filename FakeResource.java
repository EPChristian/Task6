package com.dmdev.exceptions;

import java.io.IOException;

public class FakeResource implements AutoCloseable{

    @Override
    public void close() throws IOException{
        throw new IOException("Ошибка ввода данных");
    };

    public void use(){
        System.out.println("Using resource");
    }

    public static void main(String[] args) {

        try (FakeResource res = new FakeResource()){
            res.use();
            throw new Exception("Исключение в try");
        } catch (Exception e){
            System.out.println("Основное исключение: " + e);
            for (Throwable t : e.getSuppressed()){
                System.out.println("Подавленное исключение: " + t);
            }
        }
    }
}
