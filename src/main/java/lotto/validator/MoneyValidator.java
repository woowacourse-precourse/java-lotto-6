package lotto.validator;

public class MoneyValidator {

    private static final int BUY_MONEY = 1000;
    private static final String ERROR = "[ERROR]";
    private static final String NULL_ERROR_MESSAGE = "금액을 입력해 주세요.";
    private static final String BLANK_ERROR_MESSAGE = "공백 없이 입력해 주세요.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자만 입력해 주세요.";
    private static final String UNDER_1000_MESSAGE = "1,000 이상으로 입력해 주세요.";
    private static final String DIVISION_ERROR_MESSAGE = "1,000 단위로 입력해 주세요.";

    public MoneyValidator(String input) {
        isNull(input);
        isContainBlank(input);
        isNumError(input);
        isUnder1000(input);
        isDivision(input);
    }

    public void isNull(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(ERROR + NULL_ERROR_MESSAGE);
        }
    }

    public void isContainBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR + BLANK_ERROR_MESSAGE);
        }
    }

    public void isNumError(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public void isUnder1000(String input) {
        if (Integer.parseInt(input) < BUY_MONEY) {
            throw new IllegalArgumentException(ERROR + UNDER_1000_MESSAGE);
        }
    }

    public void isDivision(String input) {
        if (Integer.parseInt(input) % BUY_MONEY != 0) {
            throw new IllegalArgumentException(ERROR + DIVISION_ERROR_MESSAGE);
        }
    }

}
