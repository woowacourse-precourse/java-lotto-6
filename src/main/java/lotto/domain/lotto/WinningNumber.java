package lotto.domain.lotto;

import lotto.exception.constants.ErrorConsts;

import java.util.Set;

public class WinningNumber {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(final LottoNumbers winningNumbers, final LottoNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final LottoNumbers winningNumbers, final LottoNumber bonusNumber) {
        validateDuplicatedBonusNumber(winningNumbers, bonusNumber);
    }

    private void validateDuplicatedBonusNumber(final LottoNumbers winningNumbers, final LottoNumber bonusNumber) {
        Set<LottoNumber> lottoNumbers = Set.copyOf(winningNumbers.numbers());

        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorConsts.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }


}
