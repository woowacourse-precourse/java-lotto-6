package lotto.domain;

import static lotto.constant.ErrorMessage.NO_DUPLICATION_ALLOWED;
import static lotto.constant.ErrorMessage.ONLY_NUMBERS_ALLOWED;
import static lotto.constant.ErrorMessage.WRONG_NUMBER_RANGE;
import static lotto.constant.GameNumber.MAX_NUMBER;
import static lotto.constant.GameNumber.MIN_NUMBER;

public class Bonus {

    private final int number;

    public Bonus(String input, Lotto winLotto) {
        this.number = validateNumeral(input);
        validateNumber();
        validateDuplication(winLotto);
    }

    public int getNumber() {
        return number;
    }

    private int validateNumeral(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBERS_ALLOWED.getMessage());
        }
    }

    private void validateNumber() {
        if (number < MIN_NUMBER.getNumber() || number > MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(WRONG_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplication(Lotto winLotto) {
        for (Integer winNumber : winLotto.getNumbers()) {
            if (number == winNumber) {
                throw new IllegalArgumentException(NO_DUPLICATION_ALLOWED.getMessage());
            }
        }
    }
}
