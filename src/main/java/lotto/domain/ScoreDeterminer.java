package lotto.domain;

import java.util.List;
import lotto.constants.Rank;

public class ScoreDeterminer {
    private WinningNumbers winningNumbers;

    public void setFirstRankNumbers(List<String> inputNumbers) {
        winningNumbers = new WinningNumbers(inputNumbers);
    }

    public void setBonusNumber(String userInput) {
        winningNumbers.setBonusNumber(userInput);
    }

    public Rank getRankOf(Lotto lotto) {
        int matchedCount = compareFirstRankNumberWith(lotto);
        boolean isMatchedWithBonusNumber = compareBonusNumberWith(lotto);
        Rank rank = Rank.getRankBy(matchedCount);
        if (rank == Rank.THIRD && isMatchedWithBonusNumber) {
            return Rank.SECOND;
        }
        return rank;
    }

    private int compareFirstRankNumberWith(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> firstRankNumbers = winningNumbers.getFirstRankLotto().getNumbers();
        return numbers.stream().filter(firstRankNumbers::contains).toList().size();
    }

    private boolean compareBonusNumberWith(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();
        return numbers.contains(bonusNumber);
    }
}
