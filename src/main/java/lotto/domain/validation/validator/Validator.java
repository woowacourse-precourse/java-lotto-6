package lotto.domain.validation.validator;

import java.util.List;

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
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void checkBonusNumberInRange(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    public void checkWinningNumberContainsBonusNumber(List<Integer> numbers, String input) {
        if (numbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException();
        }
    }
}
