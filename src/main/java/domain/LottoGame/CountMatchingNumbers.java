package domain.LottoGame;

import domain.WinningNumbers;
import lotto.Lotto;
import java.util.HashSet;
import java.util.Set;

class CountMatchingNumbers {
    public static int getCountMatchingNumbers(Lotto userLotto, WinningNumbers winningNumbers) {
        Set<Integer> userNumbersSet = new HashSet<>(userLotto.getNumbers());
        Set<Integer> winningNumbersSet = new HashSet(winningNumbers.getWinningLotto().getNumbers());

        userNumbersSet.retainAll(winningNumbersSet);

        int matchCount = userNumbersSet.size();
        if (matchCount == 5 && userNumbersSet.contains(winningNumbers.getBonusNumber())) {
            matchCount = 6;
        }
        return matchCount;
    }
}

