package lotto.domain;

import java.util.List;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class BonusNumber extends LottoNumber {
    private BonusNumber(final int number) {
        super(number);
    }

    public static BonusNumber of(final int bonusNumber, final List<LottoNumber> lottoNumbers) {
        validate(bonusNumber);
        isNotDuplicatedWithWinningNumbers(LottoNumber.from(bonusNumber), lottoNumbers);
        return new BonusNumber(generateBonusNumber(lottoNumbers));
    }

    private static void isNotDuplicatedWithWinningNumbers(final LottoNumber bonusNumber,
                                                          final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw LottoInputException.of(
                    LottoInputExceptionMessage.BONUS_NUMBER_IS_DUPLICATED_WITH_WINNING_LOTTO_NUMBERS);
        }
    }

    private static int generateBonusNumber(final List<LottoNumber> lottoNumbers) {
        return -1;
    }
}