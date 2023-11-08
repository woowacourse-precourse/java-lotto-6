package lotto.domain.lottoWinning;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottoResult.LottoResultStatus;

public class LottoWinning {
    private static final int FIVE_MATCH = 5;
    private static final int FIVE_BONUS_MATCH = 7;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    public LottoWinning(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResultStatus calculateLottoResultStatus(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = getMatchCount(numbers);
        if (matchCount == FIVE_MATCH && isBonusMatch(numbers)) {
            return LottoResultStatus.from(FIVE_BONUS_MATCH);
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
