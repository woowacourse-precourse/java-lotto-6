package lotto.domain;

import java.util.List;

public class BonusNumber extends LottoNumber {
    private BonusNumber(final long number) {
        super(number);
    }

    public static BonusNumber from(final List<LottoNumber> lottoNumbers, final long bonusNumber) {
        validate(bonusNumber);
        return new BonusNumber(generateBonusNumber(lottoNumbers));
    }

    private static long generateBonusNumber(final List<LottoNumber> lottoNumbers) {
        return -1;
    }
}