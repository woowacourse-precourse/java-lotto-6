package lotto.util.parser;

import lotto.constant.InputMessage;

public class AmountParser implements InputParser<Integer> {

    @Override
    public Integer parse(String input) {
        validateIsNotBlank(input);
        return convertToNumber(input);
    }

    private void validateIsNotBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(InputMessage.ERROR_AMOUNT_IS_BLANK);
        }
    }

    private Integer convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputMessage.ERROR_AMOUNT_NOT_A_NUMBER);
        }
    }
}
