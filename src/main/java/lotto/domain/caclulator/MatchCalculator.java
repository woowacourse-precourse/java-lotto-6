package lotto.domain.caclulator;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.WinningNumbers;

public class MatchCalculator {

    public static int calculateMatchCount(Lotto userLotto, WinningNumbers winningNumbers) {
        Set<LottoNumber> userNumbers = new HashSet<>(userLotto.getNumbers());
        Set<LottoNumber> winningNumbersSet = new HashSet<>(
                winningNumbers.getWinningLotto().getNumbers());

        userNumbers.retainAll(winningNumbersSet);
        return userNumbers.size();
    }

    public static boolean isBonusNumberMatched(Lotto userLotto, WinningNumbers winningNumbers) {
        return userLotto.getNumbers().contains(winningNumbers.getBonusNumber());
    }
}