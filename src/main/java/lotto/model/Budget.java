package lotto.model;

import static lotto.Constant.LOTTO_TICKET_PRICE;
import static lotto.ErrorMessage.*;
import static lotto.Util.convertStringToInt;

public class Budget {
    private int budget;

    public Budget(String budgetStr) {
        Validator.validate(budgetStr);
        this.budget = convertStringToInt(budgetStr);
    }

    public Budget(int budget) {
        this.budget = budget;
    }

    public int getLottoAmount() {
        return budget / LOTTO_TICKET_PRICE;
    }
    public int getBudget() {
        return budget;
    }

    public static class Validator {
        public static void validate(String input) {
            checkConvertStringToInt(input);
            checkPositiveInteger(input);
            checkModuloResultZero(input);
        }

        public static void checkConvertStringToInt(String input) {
            try {
                Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(NOT_INT.getMessage());
            }
        }

        public static void checkPositiveInteger(String input) {
            int budget = Integer.parseInt(input);
            if (budget < 0) {
                throw new IllegalArgumentException(NOT_POSITIVE.getMessage());
            }
        }

        public static void checkModuloResultZero(String input) {
            int budget = Integer.parseInt(input);
            if (budget % LOTTO_TICKET_PRICE != 0) {
                throw new IllegalStateException(MUST_MOD_RESULT_ZERO.getMessage());
            }
        }
    }
}
