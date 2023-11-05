package lotto.model;

import static lotto.constants.Error.DUPLICATE_INVALID;

public class Prize {
    private final Lotto lotto;
    private final LottoNumber bonus;

    private Prize(Lotto lotto, LottoNumber bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static Prize of(Lotto lotto, LottoNumber bonus) {
        return new Prize(lotto, bonus);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonus() {
        return bonus;
    }

    private static void validate(Lotto lotto, LottoNumber bonus) {
        if (lotto.isMatchNumber(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_INVALID.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prize\n");
        sb.append("로또 당첨 번호: ").append(lotto).append("\n");
        sb.append("보너스 번호: ").append(bonus).append("\n");
        return sb.toString();
    }
}
