package lotto.utils.validator;


import java.util.List;

import static lotto.constant.constant.*;

public class UnitValidator {
    public static void validMoneyUnitCheck(int money) {
        if (unitMinCheck(money)) {
            throw new IllegalArgumentException("1000원 이상으로 입력해주세요.");
        }
        if (rangeCheck(money)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    public static void validNumberUnitCheck(List<Integer> integers) {
        List<Integer> collected = integers.stream()
                .filter(integer -> integer >= LOTTO_MIN_UNIT)
                .filter(integer -> integer <= LOTTO_MAX_UNIT)
                .toList();

        if (collected.size() != integers.size()) {
            throw new IllegalArgumentException("로또 범위에 맞게 입력해주세요. 1 이상 45 이하입니다.");
        }
    }
    public static void validBonusUnitCheck(int money) {
        if (bonusRangeCheck(money)) {
            throw new IllegalArgumentException("로또 범위에 맞게 입력해주세요. 1 이상 45 이하입니다.");
        }
    }
    private static boolean bonusRangeCheck(int money) {
        return (money < LOTTO_MIN_UNIT) || (money > LOTTO_MAX_UNIT);
    }
    private static boolean unitMinCheck(int money) {
        return money < 1000;
    }
    private static boolean rangeCheck(int money) {
        return money % LOTTO_PURCHASED_UNIT > 0;
    }
}
