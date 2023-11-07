package lotto.exception;

import static lotto.domain.constant.StringConstant.LOTTO_BONUSNUM_DUPLICATE_ERROR;
import static lotto.service.OutputService.printError;

public class DuplicateBonusNumException extends IllegalArgumentException {
    public DuplicateBonusNumException() {
        printError(LOTTO_BONUSNUM_DUPLICATE_ERROR);
    }
}
