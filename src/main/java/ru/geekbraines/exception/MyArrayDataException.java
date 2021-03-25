package ru.geekbraines.exception;

public class MyArrayDataException extends RuntimeException{
    private int rowIndex;
    private int colIndex;

    public MyArrayDataException(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
    }

    @Override
    public String getMessage() {
        return "Неверные данные в ячейке [" + rowIndex + "][" + colIndex + "]";
    }
}
