package lotto.utils.validator;


import java.util.List;

import static lotto.constant.constant.*;

public class UnitValidator {
    public static void validMoneyUnitCheck(int money) {
        if (moneyRangeCheck(money)) {
            throw new IllegalArgumentException("1000원 이상의 1000원 단위의 금액을 입력해주세요.");
        }
    }

    public static void validNumberUnitCheck(List<Integer> integers) {
        List<Integer> collected = integers.stream()
                .filter(integer -> lottoRangeCheck(integer))
                .toList();

        if (collected.size() != integers.size()) {
            throw new IllegalArgumentException("로또 범위에 맞게 입력해주세요. 1 이상 45 이하입니다.");
        }
    }
    public static void validBonusUnitCheck(int money) {
        if (!lottoRangeCheck(money)) {
            throw new IllegalArgumentException("로또 범위에 맞게 입력해주세요. 1 이상 45 이하입니다.");
        }
    }
    private static boolean lottoRangeCheck(int money) {
        return (money >= LOTTO_MIN_UNIT) && (money <= LOTTO_MAX_UNIT);
    }
    private static boolean moneyRangeCheck(int money) {
        return (money % LOTTO_PURCHASED_UNIT > 0) || (money < 1000);
    }
}
