package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoMoney.MONEY_UNIT;
import static lotto.util.ErrorMessage.*;

public class Validator {

    private Validator() { }

    public static void validateMoney(int money) {
        checkPositive(money);
        checkUnit(money);
    }

    private static void checkPositive(int money) {
        if (isNotPositive(money)) {
            throw new IllegalArgumentException(NEGATIVE_INT_ERROR.getMessage());
        }
    }

    private static boolean isNotPositive(int money) {
        return money <= 0;
    }

    private static void checkUnit(int money) {
        if (money < MONEY_UNIT || money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR.getMessage());
        }
    }

    public static void validateNumbers(List<Integer> target) {
        checkSize(target);
        checkDuplicate(target);
    }

    private static void checkSize(List<Integer> target) {
        if (target.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private static void checkDuplicate(List<Integer> target) {
        Set<Integer> temp = new HashSet<>(target);
        if (temp.size() != target.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR.getMessage());
        }
    }
}
