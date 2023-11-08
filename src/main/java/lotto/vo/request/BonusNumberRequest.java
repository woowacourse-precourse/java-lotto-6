package lotto.vo.request;

import static lotto.constants.ErrorMessage.NOT_INTEGER;

import lotto.domain.BonusNumber;

public class BonusNumberRequest {
    private final Integer number;

    public BonusNumberRequest(String input) {
        String cleanedInput = cleanseWhitespace(input);
        this.number = validateInteger(cleanedInput);
    }

    private String cleanseWhitespace(String input) {
        return input.trim();
    }

    private Integer validateInteger(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    public BonusNumber convertToValidBonusNumber() {
        return new BonusNumber(number);
    }
}
