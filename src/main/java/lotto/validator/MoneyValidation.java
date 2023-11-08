package lotto.validator;

public class MoneyValidation {

    final String condition = "^[0-9]+$";              //정규식 사용
    final String numberError = "[ERROR] 숫자를 입력하십시오.";
    final String moneyError = "[ERROR] 1000에 나누어 떨어지는 수를 입력해주세요.";

    public void validate(String input){
        checkNumber(input);
        checkPrice(input);
    }


    private void checkNumber(String input){
        if(!input.matches(condition))
            throw new IllegalArgumentException(numberError);
    }
    private void checkPrice(String input){
        if((Integer.parseInt(input)%1000)!=0)           //validate를 String input으로 한번에 묶으려다 보니 if안에 식을 넣음
            throw new IllegalArgumentException(moneyError);
    }
}
