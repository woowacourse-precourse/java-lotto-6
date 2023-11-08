package lotto.util;

import lotto.validation.LottoValidation;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static final int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static final List<Integer> convertStringToIntList(String input) {
        List<Integer> result = new ArrayList<>();
        for (String num : input.split(",")) {
            result.add(Integer.parseInt(num));
        }
        return result;
    }

    public static final void validateWinningNumber(List<Integer> winningNumber) {
        LottoValidation.validateIsSize(winningNumber.size());
        LottoValidation.validateIsDuplicated(winningNumber);
        for (Integer number : winningNumber) {
            LottoValidation.validateInRange(number);
        }
    }

    public static final void validateAmount(int amount) {
        LottoValidation.validateOverStandardUnit(amount);
        LottoValidation.validateIsStandardUnit(amount);
    }

    public static final void validateIsNumber(String input) {
        LottoValidation.validateIsNumber(input);
    }

    public static final void validateBonusNumber(int number) {
        LottoValidation.validateInRange(number);
    }
}
