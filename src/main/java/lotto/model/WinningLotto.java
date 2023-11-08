package lotto.model;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningCriteria computeRank(List<Integer> lottoNumbers) {
        int matchingCount = (int) winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
        if (matchingCount == 5 && validateBonusNumber(lottoNumbers)) {
            return lotto.model.WinningCriteria.SECOND;
        }
        return Arrays.stream(WinningCriteria.values())
                .filter(wc -> wc.matchNumberCount(matchingCount))
                .findAny()
                .orElse(lotto.model.WinningCriteria.NONE);
    }

    private boolean validateBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
