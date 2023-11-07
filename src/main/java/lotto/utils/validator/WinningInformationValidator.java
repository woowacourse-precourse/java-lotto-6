package lotto.utils.validator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.utils.message.WinningInformationExceptionMessage;

public class WinningInformationValidator {
    public static void validate(Lotto lotto, LottoNumber lottoNumber) {
        if (lotto.isContains(lottoNumber)) {
            throw new IllegalArgumentException(
                    WinningInformationExceptionMessage.WINNING_AND_BONUS_DUPLICATE_EXISTS.getError());
        }
    }
}
