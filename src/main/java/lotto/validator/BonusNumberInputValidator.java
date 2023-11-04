package lotto.validator;

public class BonusNumberInputValidator implements BasicValidator<String> {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String INPUT_NOT_NUMERIC = "[ERROR] 입력값이 숫자가 아닙니다.";
    private static final String INPUT_NOT_BETWEEN_ONE_AND_FORTY_FIVE = "[ERROR] 입력값이 1과 45 사이여야 합니다.";

    @Override
    public void validate(String input) {
        isNumeric(input);
        isBetweenOneAndFortyFive(input);
    }

    private void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_NUMERIC);
        }
    }

    private void isBetweenOneAndFortyFive(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INPUT_NOT_BETWEEN_ONE_AND_FORTY_FIVE);
        }
    }
}
