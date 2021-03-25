package ru.geekbraines.exception;

public class App {

    public static void main(String[] args) {
        String [][] sArray = {
                {"1", "2", "3", "4"},
                {"5", "[", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        App a = new App();
        //System.out.println(Integer.parseInt("[12"));
        try {
            int S;
            S = a.castAndSumm(sArray);
            System.out.println("Сумма элементов массива: " + S);
        } catch (MyArraySizeException e) {
            System.out.println("Размер массива должен быть 4х4");
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    private int castAndSumm(String[][] strArray) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;
        if (strArray[0].length != 4 || strArray.length != 4) {
            //System.out.println("надел доспех - имею успех");
            throw new MyArraySizeException();
        }
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                String tmpCell = strArray[i][j];
                if (strArray[i][j].isEmpty()) {
                    throw new MyArrayDataException(i,j);
                }
                for (int k = 0; k < tmpCell.length(); k++) {
                    if (tmpCell.charAt(k) < '0' ||  tmpCell.charAt(k) > '9') {
                        throw new MyArrayDataException(i,j);
                    }
                }
                int intCell = Integer.parseInt(strArray[i][j]);
                summ = summ + intCell;
            }
        }
        //System.out.println("Надел доспех - имею успех");
        return summ;
    }

}
