package domain.LottoGame;

import domain.WinningNumbers;
import lotto.Lotto;
import java.util.HashSet;
import java.util.Set;

class CountMatchingNumbers {
    public static int getCountMatchingNumbers(Lotto userLotto, WinningNumbers winningNumbers) {
        Set<Integer> userNumbersSet = new HashSet<>(userLotto.getNumbers());
        Set<Integer> winningNumbersSet = new HashSet(winningNumbers.getWinningLotto().getNumbers());
        Set<Integer> getNumbersSet = new HashSet<>(userLotto.getNumbers());
        userNumbersSet.retainAll(winningNumbersSet);
        int matchCount = userNumbersSet.size();
        if (matchCount == 6) {
            return matchCount;
        }
        if (matchCount == 5 && getNumbersSet.contains(winningNumbers.getBonusNumber())) {
            return -1;
        }
        return matchCount;
    }
}

