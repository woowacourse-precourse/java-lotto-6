package lotto.Domain;

import lotto.Constant.Constant;

public class Money {
    private static final String NOT_NUMBER_MESSAGE = "숫자만 입력해야 합니다.";
    private static final String CANT_DIVISION_MESSAGE = "원 단위의 금액을 입력해야 합니다.";
    private final int value;

    public Money(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        validateIsNumber(value);
        validateMoney(value);
    }

    private void validateIsNumber(String value) {
        if (!value.matches(Constant.NUMBER_PATTERN)) {
            String errorMessage = Constant.ERROR_PREFIX + NOT_NUMBER_MESSAGE;
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // 금액이 LOTTO_PRICE로 나누어 떨어지는지 검사한다.
    private void validateMoney(String value) {
        int inputMoney = Integer.parseInt(value);

        if (inputMoney % Constant.LOTTO_PRICE != 0) {
            String errorMessage = Constant.ERROR_PREFIX + Constant.LOTTO_PRICE + CANT_DIVISION_MESSAGE;
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public int getValue() {
        return value;
    }
}
