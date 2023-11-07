package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_BONUSNUM_DUPLICATE_ERROR;

public class DuplicateBonusNumException extends IllegalArgumentException {
    public DuplicateBonusNumException() { super(LOTTO_BONUSNUM_DUPLICATE_ERROR); }
}
