package util;

import lotto.Lotto;
import lotto.Money;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static final int ZERO = 0;
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    public static void validateDigits(String readLine) {
        if (!readLine.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다. readLine: " + readLine);
        }
    }
    public static void validateMinimumMoney(int money) {
        if (money < Money.UNIT) {
            throw new IllegalArgumentException("[ERROR] 천원 이하는 복권을 살 수 없습니다. money: " + money);
        }
    }
}
