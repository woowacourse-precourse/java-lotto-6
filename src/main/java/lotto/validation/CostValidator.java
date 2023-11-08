package lotto.validation;

import static lotto.constants.Constants.LOTTO_COST;

import lotto.exception.CostUnitDivideException;
import lotto.exception.CostZeroException;

public class CostValidator extends Validator {
    public static void validateCostReadLine(String readline) {
        checkBlank(readline);
        checkDigit(readline);
    }

    public static void validateParsedCost(int cost) {
        checkDivideUnit(cost);
        checkZero(cost);
    }

    private static void checkDivideUnit(int cost) {
        if (cost % LOTTO_COST != 0) {
            throw CostUnitDivideException.costUnitDivideException;
        }
    }

    private static void checkZero(int cost) {
        if (cost == 0) {
            throw CostZeroException.costZeroException;
        }
    }
}
