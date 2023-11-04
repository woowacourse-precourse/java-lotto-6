package lotto.validation;

public class InputValidation {

    private static final String ERROR = "[ERROR] ";
    private static final String IS_NULL_MESSAGE = "빈 문자열 입니다";
    private static final String IS_NOT_NUMBER_MESSAGE = "숫자가 아닙니다";

    public void validationMoney(String input){
        isEmptyValidation(input);
        isNumberValidation(input);
    }

    private void isEmptyValidation(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException(ERROR + IS_NULL_MESSAGE);
        }
    }

    private void isNumberValidation(String input){
        for(int i = 0; i<input.length() ; i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException(ERROR + IS_NOT_NUMBER_MESSAGE);
            }
        }
    }
}
