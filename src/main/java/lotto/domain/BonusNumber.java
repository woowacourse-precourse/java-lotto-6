package lotto.domain;

import static lotto.constant.ErrorMessage.BONUS_DUPLICATED;

public class BonusNumber {
    private final LottoNumber lottoNumber;

    public BonusNumber(LottoNumber lottoNumber, Lotto winningTicket) {
        validateNotDuplicated(lottoNumber, winningTicket);
        this.lottoNumber = lottoNumber;
    }

    private void validateNotDuplicated(LottoNumber lottoNumber, Lotto winningTicket) {
        if (winningTicket.hasNumber(lottoNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATED);
        }
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }
}
