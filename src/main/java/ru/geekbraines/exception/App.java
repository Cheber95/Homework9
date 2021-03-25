package ru.geekbraines.exception;

public class App {

    public static void main(String[] args) {
        String [][] sArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "m"}
        };
        App a = new App();
        try {
            int S;
            S = a.castAndSumm(sArray);
            System.out.println("Сумма элементов массива: " + S);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private int castAndSumm(String[][] strArray) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;
        if (strArray[0].length != 4 || strArray.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                try {
                    int intCell = Integer.parseInt(strArray[i][j]);
                    summ = summ + intCell;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return summ;
    }
}
