package com.dmdev.exceptions;

import java.util.Scanner;

public class InvalidAgeException extends Exception{
    public InvalidAgeException (String message) {
        super (message);
    }

    public static void validateAge(int age) throws InvalidAgeException{
        if (age < 0 || age > 150){
            throw new InvalidAgeException("Недопустимый возраст");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите возраст: ");

            try {
                int age = Integer.parseInt(scanner.nextLine());
                validateAge(age);
                System.out.println("Ваш возраст: " + age);
            } catch (InvalidAgeException e){
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное целое число ");
            }
    }
}
