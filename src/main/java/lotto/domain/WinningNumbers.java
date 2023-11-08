package lotto.domain;

import java.util.List;
import lotto.validator.Validator;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        Validator.validateContainsBonusNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean containsLottoNumber(int lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean matchBonusNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
