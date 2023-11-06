package lotto.utils;

public class Validator {

    public static void checkAmount(Integer purchaseAmount) throws IllegalArgumentException{
        if((purchaseAmount % 1000) != 0 || purchaseAmount <= 0){
            throw new IllegalArgumentException("[ERROR] 1,000 단위로 입력 해주세요");
        }
    }

    public static String checkNullValue(String inputValue) throws IllegalArgumentException{
        if(inputValue == ""){
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다 확인해주세요");
        }
        return inputValue;
    }
}
