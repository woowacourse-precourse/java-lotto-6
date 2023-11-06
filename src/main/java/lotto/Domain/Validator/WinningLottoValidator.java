package lotto.Domain.Validator;

import static lotto.Util.Constants.LOTTO_NUMBER_LENGTH;
import static lotto.Util.Constants.MAX_LOTTO_NUM;
import static lotto.Util.Constants.MIN_LOTTO_NUM;

import java.util.List;
import lotto.Domain.BonusNumber;
import lotto.Domain.Lotto;
import lotto.Util.ExceptionMessageFormatter;
import lotto.Util.LottoGameException;

public class WinningLottoValidator {
    private WinningLottoValidator() {

    }

    public static void doValidate(Lotto winningLotto, BonusNumber bonusNumber) {
        if( hasBonusNumInWinningLotto(winningLotto,bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessageFormatter.makeMessage(LottoGameException.INCLUDE_BONUS_NUMBER.getMessage()));
        }
    }

    private static boolean hasBonusNumInWinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        return winningLotto.hasNumber(bonusNumber.getBounusNum());
    }
}
