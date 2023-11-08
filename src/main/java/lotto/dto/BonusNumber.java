package lotto.dto;

import lotto.utils.Parser;

public class BonusNumber {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final String OUT_RANGE_ERROR_MESSAGE = "[ERROR] 범위를 벗어난 숫자 입니다.";
    private static final String NULL_INPUT_ERROR_MESSAGE = "[ERROR] 금액을 정확히 입력해 주세요.";

    private int bonusNumber;

    private BonusNumber(String userInput) {
        try {
            validateNullValue(userInput);
            this.bonusNumber = Parser.parseStringToInt(userInput);
            validInRangeNumber();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static BonusNumber create(String userInput) {
        return new BonusNumber(userInput);
    }

    private void validInRangeNumber() {
        if (bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new IllegalArgumentException(OUT_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateNullValue(String value) {
        if (value.isBlank()) throw new IllegalArgumentException(NULL_INPUT_ERROR_MESSAGE);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
