package lotto.domain;

import lotto.constants.LottoConstants;

public class Bonus {

    private final int bonus;

    private Bonus(final int bonus) {
        this.bonus = bonus;
    }

    public static Bonus from(final int bonus) {
        validate(bonus);
        return new Bonus(bonus);
    }

    private static void validate(final int bonus) {
        if (!isBoundary(bonus)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 보너스 번호는 %d 부터 %d 이내입니다.", LottoConstants.MIN_NUMBER.getConstants(),
                            LottoConstants.MAX_NUMBER.getConstants())
            );
        }
    }

    private static boolean isBoundary(final int bonus) {
        return LottoConstants.MIN_NUMBER.getConstants() <= bonus && bonus <= LottoConstants.MAX_NUMBER.getConstants();
    }

    public static boolean isSameNumber(final Lotto given, final Bonus bonus) {
        return given.getLotto().stream().anyMatch(n -> n == bonus.getBonus());
    }

    public int getBonus() {
        return bonus;
    }
}
