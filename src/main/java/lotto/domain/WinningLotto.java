package lotto.domain;

import static lotto.exception.ErrorType.BonusNumberDuplicatedException;

import lotto.exception.LottoException;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final Number bonusNumber;

    public WinningLotto(final Lotto inputLottoNumbers, final Number inputBonusNumber) {
        validateDuplicated(inputLottoNumbers, inputBonusNumber);
        this.winningNumbers = inputLottoNumbers;
        this.bonusNumber = inputBonusNumber;
    }

    private void validateDuplicated(final Lotto lotto, final Number bonusNumber) {
        boolean contains = lotto.contains(bonusNumber);
        if (contains) {
            throw new LottoException(BonusNumberDuplicatedException);
        }
    }

    public LottoRank match(final Lotto lottoNumbers) {
        int count = countMatch(lottoNumbers);
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);
        return LottoRank.of(count, bonusMatch);
    }

    private int countMatch(final Lotto lottoNumbers) {
        return (int) winningNumbers.getNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }

}
