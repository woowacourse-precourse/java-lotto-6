package lotto.validation;

import lotto.exception.CostUnitDivideException;
import lotto.exception.CostZeroException;
import lotto.exception.IncludeCharException;
import lotto.exception.InputBlankException;

public class CostValidator {
    public static void validateReadLine(String readline) {
        checkBlank(readline);
        checkDigit(readline);
    }

    public static void validateParsedCost(int cost) {
        checkDivideUnit(cost);
        checkZero(cost);
    }

    private static void checkBlank(String readline) {
        if (readline == null || readline.isBlank()) {
            throw InputBlankException.inputBlankException;
        }
    }

    private static void checkDigit(String readLine) {
        for (int i = 0; i < readLine.length(); i++) {
            if (!Character.isDigit(readLine.charAt(i))) {
                throw IncludeCharException.includeCharException;
            }
        }
    }

    private static void checkDivideUnit(int cost) {
        if (cost % 1000 != 0) {
            throw CostUnitDivideException.costUnitDivideException;
        }
    }

    private static void checkZero(int cost) {
        if (cost == 0) {
            throw CostZeroException.costZeroException;
        }
    }
}
