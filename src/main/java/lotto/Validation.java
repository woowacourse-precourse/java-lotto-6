package lotto;

import lotto.model.Errors;

import java.util.List;

public class Validation {
    private static final String IS_ONLY_NUMBER = "[0-9]+";
    public int isDuplicate(List<Integer> lotto, int bonus) {
        if (!lotto.contains(bonus))
            return bonus;
        throw new IllegalArgumentException(Errors.BONUS.getMessage());
    }
    public int isNumberValid(String number) {
        try {
            if (isInteger(number) && isRangeValid(number))
                return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return 0;
    }
    public boolean isInteger(String number) {
        if (number.matches(IS_ONLY_NUMBER))
            return true;
        throw new IllegalArgumentException(Errors.INTEGER.getMessage());
    }
    public boolean isRangeValid(String number) {
        int parsed = Integer.parseInt(number);
        if (1 <= parsed && parsed < 46)
            return true;
        throw new IllegalArgumentException(Errors.RANGE.getMessage());

    }
}
