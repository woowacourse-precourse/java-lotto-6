package lotto.domain;

public class LottoMoney {

    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";

    private int money;

    public LottoMoney(String input) {
        this.money = validate(input);
    }

    private int validate(String input) {
        int integerMoney = validateCorrectNumber(input);
        return integerMoney;
    }

    private int validateCorrectNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
