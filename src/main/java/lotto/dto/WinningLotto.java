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

    public static WinningLotto of(String winning, String bonus) {
        return new WinningLotto(new Lotto(winning), LottoNumber.from(bonus));
    }

    public boolean hasTargetLottoNumber(LottoNumber target) {
        return winning.getNumbers().contains(target);
    }

    private void validateNotDuplicated(Lotto winning, LottoNumber bonus) {
        if (winning.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}
