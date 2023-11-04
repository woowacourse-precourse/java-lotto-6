package lotto.validation;

public class InputValidation {

    private static final String ERROR = "[ERROR] ";
    private static final String IS_NULL_MESSAGE = "빈 문자열 입니다";

    public void validationMoney(String input){
        isEmptyValidation(input);
    }

    private void isEmptyValidation(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException(ERROR + IS_NULL_MESSAGE);
        }
    }
}
