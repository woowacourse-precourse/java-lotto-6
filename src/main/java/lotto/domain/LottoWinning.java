package lotto.domain;

import java.util.List;
import lotto.constant.LottoResultStatus;

public class LottoWinning {
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public LottoWinning(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResultStatus calculateLottoResultStatus(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = getMatchCount(numbers);
        if (matchCount == 5 && isBonusMatch(numbers)) {
            return LottoResultStatus.from(7);
        }
        return LottoResultStatus.from(matchCount);
    }

    private int getMatchCount(List<Integer> numbers) {
        List<Integer> getWinningNumbers = winningNumbers.getWinningNumbers();
        return (int) numbers.stream().filter(getWinningNumbers::contains).count();
    }

    private boolean isBonusMatch(List<Integer> numbers) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }
}
