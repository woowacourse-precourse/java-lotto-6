package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
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
