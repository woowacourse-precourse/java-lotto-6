package lotto.model;

import java.util.List;

public class LottoResult {

    int totalReward;

    public WinningRank check(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> comparingNumbers = winningNumbers.getWinningNumbers();

        int matchedCount = (int) numbers.stream().filter(comparingNumbers::contains).count();
        boolean bonusMatched = numbers.contains(winningNumbers.getBonusNumber());

        return WinningRank.valueOf(matchedCount, bonusMatched);
    }
}
