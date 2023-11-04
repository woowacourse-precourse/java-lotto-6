package lotto.domain;

import java.util.List;
import lotto.utils.StringChanger;

public class LottoScoreChecker {
    private final WinningNumbers winningNumbers = new WinningNumbers();

    public void setFirstNumbers(String userInput) {
        List<String> inputNumbers = StringChanger.stringToTrimmedStringList(userInput);
        winningNumbers.setFirstRankLotto(inputNumbers);
    }

    public void setBonusNumber(String userInput) {
        userInput = StringChanger.trimString(userInput);
        winningNumbers.setBonusNumber(userInput);
    }

    public Rank getRank(Lotto lotto) {
        int matchedCount = compareToFirstRankNumber(lotto);
        boolean isMatchedWithBonusNumber = compareToBonusNumber(lotto);
        Rank rank = Rank.getRankByMatchCount(matchedCount);
        if (rank == Rank.FIVE_MATCH && isMatchedWithBonusNumber) {
            return Rank.FIVE_AND_BONUS_MATCH;
        }
        return rank;
    }

    public int compareToFirstRankNumber(Lotto lotto) {
        List<Integer> numbers = lotto.showNumbers();
        List<Integer> firstNumbers = winningNumbers.getFirstRankLotto().showNumbers();
        return numbers.stream().filter(firstNumbers::contains).toList().size();
    }

    public boolean compareToBonusNumber(Lotto lotto) {
        List<Integer> numbers = lotto.showNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();
        return numbers.contains(bonusNumber);
    }
}
