package lotto;

import java.util.List;

public class LottoEvaluator {

    public static Rank evaluate(Lotto userLotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = countMatches(userLotto, winningLotto);
        boolean bonusMatch = userLotto.contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    private static int countMatches(Lotto userLotto, Lotto winningLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
