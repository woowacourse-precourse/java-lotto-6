package lotto.domain.validation.validator;

import java.util.List;

import static lotto.domain.constants.LottoConstraint.*;

public class Validator {
    public boolean isInputInteger(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void isPurchaseAmountPositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void isPurchaseAmountDividedUp(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void checkBonusNumberInRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < NUMBER_RANGE_MINIMUM.getValue() || bonusNumber > NUMBER_RANGE_MAXIMUM.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkWinningNumberContainsBonusNumber(List<Integer> numbers, String input) {
        if (numbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException();
        }
    }
}
