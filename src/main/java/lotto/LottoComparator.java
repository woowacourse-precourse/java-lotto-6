package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoComparator {

    public LottoComparator() {
    }

    public WinningLotto compareLotto(List<Integer> winningNumbers, Integer bonus, Lotto lotto) {
        int matchWinningNumbersCount = lotto.countWinningNumbers(winningNumbers);
        int matchBonusCount = lotto.countBonusMatch(bonus);

        return Arrays.stream(WinningLotto.values())
                .filter(winningLotto -> winningLotto.getLottoRank(matchWinningNumbersCount, matchBonusCount))
                .findFirst()
                .orElse(WinningLotto.LAST_PLACE);
    }
}
