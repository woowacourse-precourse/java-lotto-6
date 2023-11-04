package lotto.view.validator;


import static lotto.Const.Const.LOTTO_PURCHASED_UNIT;

public class UnitValidator {
    public static int LOTTO_MIN_UNIT = 1;
    public static int LOTTO_MAX_UNIT = 45;
    public static void validUnitCheck(int money) {
        if (unitMinCheck(money)) {
            throw new IllegalArgumentException("1000원 이상으로 입력해주세요.");
        }
        if (rangeCheck(money)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
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
