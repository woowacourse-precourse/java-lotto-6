package lotto.domain;

import static lotto.constants.ErrorCode.DUPLICATED_LOTTO_NUMBER;

public class WinningLotto {
    private final Lotto winning;
    private final LottoNumber bonus;

    private WinningLotto(Lotto winning, LottoNumber bonus) {
        validateNotDuplicated(winning, bonus);
        this.winning = winning;
        this.bonus = bonus;
    }

    public static WinningLotto of(Lotto winning, LottoNumber bonus) {
        return new WinningLotto(winning, bonus);
    }

    public boolean hasCertainNumber(LottoNumber target) {
        return winning.hasCertainNumber(target);
    }

    private void validateNotDuplicated(Lotto winning, LottoNumber bonus) {
        if (winning.hasCertainNumber(bonus)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}
