package lotto.util;

import java.util.List;
import lotto.domain.Lotto;

public class RankCalculator {
    private final List<Lotto> lottos;

    public RankCalculator(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    
    public int countWinningLotto(Winning winning, Lotto winningLotto, int bonusNumber) {
        int lottoCount = 0;

        for (Lotto lotto : lottos) {
            if (isWinning(winning, lotto, winningLotto, bonusNumber)) {
                lottoCount++;
            }
        }
        return lottoCount;
    }

    private boolean isWinning(Winning winning, Lotto lotto, Lotto winningLotto, int bonusNumber) {
        if (winning == Winning.FIRST) {
            return compareLotto(lotto, winningLotto) == winning.count();
        }
        if (winning == Winning.SECOND) {
            return (compareLotto(lotto, winningLotto) == winning.count()) && hasBonusNumber(lotto, bonusNumber);
        }
        int bonusCount = 0;
        if (hasBonusNumber(lotto, bonusNumber)) {
            bonusCount++;
        }
        return (compareLotto(lotto, winningLotto) + bonusCount) == winning.count();
    }

    private boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> numbers = lotto.numbers();
        return numbers.contains(bonusNumber);
    }

    private int compareLotto(Lotto lotto, Lotto winningLotto) {
        int count = 0;
        List<Integer> numbers = lotto.numbers();
        for (Integer number : numbers) {
            if (compareWinningNumbers(number, winningLotto)) {
                count++;
            }
        }
        return count;
    }

    private boolean compareWinningNumbers(int number, Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.numbers();
        return winningNumbers.contains(number);
    }
}
