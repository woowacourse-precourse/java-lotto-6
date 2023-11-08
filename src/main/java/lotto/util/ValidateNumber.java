package lotto.util;

public class ValidateNumber {

    public static int isPositiveInteger(String inputValue) {

        int inputNumber = isInteger(inputValue);
        isPositive(inputNumber);

        return inputNumber;
    }

    private static int isInteger(String inputValue) {

        if (!inputValue.matches("-?\\d+")){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }

        return Integer.parseInt(inputValue);
    }


    private static void isPositive(int inputValue){

        if(inputValue <= 0){
            throw new IllegalArgumentException("[ERROR] 0보다 큰 정수를 입력해주세요.");
        }

    }

}
