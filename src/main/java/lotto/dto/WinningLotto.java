package lotto.dto;

import static lotto.constants.ErrorCode.DUPLICATED_LOTTO_NUMBER;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

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

    private void validateNotDuplicated(Lotto winning, LottoNumber bonus) {
        if (winning.hasCertainNumber(bonus)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public Lotto getWinning() {
        return winning;
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}
