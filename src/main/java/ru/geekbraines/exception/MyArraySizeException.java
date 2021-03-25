package ru.geekbraines.exception;

public class MyArraySizeException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Размер массива должен быть 4х4";
    }
}
