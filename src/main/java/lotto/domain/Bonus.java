package lotto.domain;

import java.util.List;
import lotto.constants.ExceptionMessage;
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
                    String.format(ExceptionMessage.BONUS_OUT_RANGE, LottoConstants.MIN_NUMBER.getConstants(),
                            LottoConstants.MAX_NUMBER.getConstants())
            );
        }
    }

    private static boolean isBoundary(final int bonus) {
        return LottoConstants.MIN_NUMBER.getConstants() <= bonus && bonus <= LottoConstants.MAX_NUMBER.getConstants();
    }

    public static boolean isSameNumber(final List<Integer> given, final Bonus bonus) {
        return given.stream().anyMatch(n -> n == bonus.getBonus());
    }

    public int getBonus() {
        return bonus;
    }
}
