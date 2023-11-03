package lotto.util;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoMoney.MONEY_UNIT;
import static lotto.util.ErrorMessage.*;

public class Validator {

    private static final String NOT_SPECIAL_REGEX = "^[a-zA-Z0-9,]*$";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

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
        for (int number : target) {
            checkNegative(number);
            checkRange(number);
        }
    }

    public static void validateBonusNumber(int target) {
        checkNegative(target);
        checkRange(target);
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

    private static void checkNegative(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR.getMessage());
        }
    }

    private static void checkRange(int number) {
        if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public static void checkComma(String target) {
        if (!target.matches(NOT_SPECIAL_REGEX)) {
            throw new IllegalArgumentException(SPLIT_REGEX_ERROR.getMessage());
        }
    }

    public static void checkAlreadyContains(Lotto answerNumber, BonusNumber bonusNumber) {
        if (bonusNumber.isIn(answerNumber)) {
            throw new IllegalArgumentException(ALREADY_CONTAINS_ERROR.getMessage());
        }
    }
}
