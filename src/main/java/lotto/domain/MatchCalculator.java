package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatchCalculator {

    public static int calculateMatchCount(Lotto userLotto, WinningNumbers winningNumbers) {
        Set<LottoNumber> userNumbers =  new HashSet<>(userLotto.getNumbers());
        Set<LottoNumber> winningNumbersSet = new HashSet<>(winningNumbers.getWinningLotto().getNumbers());

        userNumbers.retainAll(winningNumbersSet);
        return userNumbers.size();
    }

    public static boolean isBonusNumberMatched(Lotto userLotto, WinningNumbers winningNumbers) {
        return userLotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }
}