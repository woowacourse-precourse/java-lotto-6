package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class  MatchLotto{

    private final List<Integer> winningMatchResult = new ArrayList<>();
    private final List<Boolean> bonusMatchResult = new ArrayList<>();


    public void matchLotto(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottoPurchaseHistory) {
        for (Lotto lotto : lottoPurchaseHistory) {
            winningMatchResult.add(matchWinningNumber(winningNumbers, lotto));
            bonusMatchResult.add(matchBonusNumber(lotto.getNumbers(), bonusNumber));
        }
    }

    private static boolean matchBonusNumber(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private static int matchWinningNumber(List<Integer> winningNumbers, Lotto lotto) {
        int match = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                match++;
            }
        }
        return match;
    }

    public List<Integer> getWinningMatchResult() {
        return winningMatchResult;
    }

    public List<Boolean> getBonusMatchResult() {
        return bonusMatchResult;
    }
}
