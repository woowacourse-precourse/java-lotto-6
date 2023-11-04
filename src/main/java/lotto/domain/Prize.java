package lotto.domain;

import static lotto.constants.Error.DUPLICATE_INVALID;
import static lotto.constants.Error.RANGE_INVALID;
import static lotto.constants.Rule.MAX_LOTTO;
import static lotto.constants.Rule.MIN_LOTTO;

public class Prize {
    private final Lotto lotto;
    private final int bonus;

    private Prize(Lotto lotto, int bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static Prize of(Lotto lotto, int bonus) {
        return new Prize(lotto, bonus);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }

    private static void validate(Lotto lotto, int bonus) {
        validateRange(bonus);
        validateDuplicate(lotto, bonus);
    }

    private static void validateDuplicate(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_INVALID.getMessage());
        }
    }

    private static void validateRange(int bonus) {
        if (!isValidNumber(bonus)) {
            throw new IllegalArgumentException(RANGE_INVALID.getMessage());
        }
    }

    private static boolean isValidNumber(int bonus) {
        return bonus >= MIN_LOTTO.getValue() && bonus <= MAX_LOTTO.getValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prize\n");
        sb.append("로또 당첨 번호: ").append(lotto.getNumbers()).append("\n");
        sb.append("보너스 번호: ").append(bonus).append("\n");
        return sb.toString();
    }
}
