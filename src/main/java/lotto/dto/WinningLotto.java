package lotto.dto;

import static lotto.enums.ErrorMassage.DUPLICATE_BONUS_NUMBER;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public record WinningLotto(Lotto lotto, LottoNumber bonus) {
    public WinningLotto {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMassage());
        }
    }
}
