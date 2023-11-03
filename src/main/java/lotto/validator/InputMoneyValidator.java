package lotto.validator;

public class InputMoneyValidator {

    private static final String ERROR = "[ERROR]";
    private static final String NULL_ERROR_MESSAGE = "금액을 입력해주세요.";
    private static final String BLANK_ERROR_MESSAGE = "공백 없이 입력해주세요.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private static final String DIVISION_ERROR_MESSAGE = "1,000 단위로 입력해주세요.";
    private final String money;

    public InputMoneyValidator(String input){
        money = input;
        isNull();
        isContainBlank();
        isNumError();
        isDivision();
    }

    public void isNull(){
        if (money.equals("")){
            throw new IllegalArgumentException(ERROR + NULL_ERROR_MESSAGE);
        }
    }

    public void isContainBlank() {
        if (money.contains(" ")){
            throw new IllegalArgumentException(ERROR + BLANK_ERROR_MESSAGE);
        }
    }

    public void isNumError(){
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public void isDivision(){
        if (Integer.parseInt(money)%1000 != 0){
            throw new IllegalArgumentException(ERROR + DIVISION_ERROR_MESSAGE);
        }
    }

}
