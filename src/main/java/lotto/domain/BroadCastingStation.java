package lotto.domain;

import lotto.error.LottoErrorMessage;

public class BroadCastingStation {
    public static LottoDrawResult drawLotto(Lotto lotto, Integer bonus) {
        LottoDrawResult lottoDrawResult = new LottoDrawResult(lotto, bonus);
        validateDuplicate(lotto, bonus);
        return lottoDrawResult;
    }

    private static void validateDuplicate(Lotto lotto, Integer bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(LottoErrorMessage.BONUS_DUPLICATED);
        }
    }
}
