package lotto.domain;

import java.util.stream.Collectors;
import lotto.util.IllegalArgumentMessage;
import lotto.util.LottoConstant;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;
    private static final int MINIMUM_WINNING_COUNT = 3;
    private static final int OUT = 0;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoConstant.MINIMUM_RANGE || bonusNumber > LottoConstant.MAXIMUM_RANGE) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_RANGE_MESSAGE);
        }
    }

    private void validateBonusNumberDuplication(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_DUPLICATION_MESSAGE);
        }
    }

    public int lottoNumbersMatch(Lotto lottoNumbers) {
        int matchCount = winningNumbers.getNumbers().stream().filter(it -> lottoNumbers.getNumbers().contains(it))
                .collect(Collectors.toList()).size();
        if (matchCount < MINIMUM_WINNING_COUNT) {
            return OUT;
        }
        return matchCount;
    }

    public boolean lottoBonusNumberMatch(Lotto lottoNumbers) {
        return lottoNumbers.getNumbers().contains(bonusNumber);
    }
}
