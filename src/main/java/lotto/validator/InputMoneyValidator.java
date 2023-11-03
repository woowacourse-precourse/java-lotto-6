package lotto.validator;

public class InputMoneyValidator {

    private static final String ERROR = "[ERROR]";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자를 입력해주세요";
    private final String money;

    public InputMoneyValidator(String input){
        money = input;
        isNumError();
    }

    public void isNumError(){
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
