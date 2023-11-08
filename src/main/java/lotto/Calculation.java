package lotto;

import lotto.utils.Rank;

import java.util.List;

public class Calculation {
    public int calculateRankCount(List<Lotto> lottos, WinningNumber winningNumber, Rank rank) {
        return (int) lottos.stream()
                .map(lotto -> calculateRank(lotto, winningNumber))
                .filter(r -> r == rank)
                .count();
    }

    private Rank calculateRank(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = countMatchedNumbers(lotto, winningNumber.getLotto());
        boolean hasBonus = lotto.getNumbers().contains(winningNumber.getBonusNumber());

        if (matchCount == 6) {
            return Rank.FIRST;
        }
        if (matchCount == 5 && hasBonus) {
            return Rank.SECOND;
        }
        if (matchCount == 5) {
            return Rank.THIRD;
        }
        if (matchCount == 4) {
            return Rank.FOURTH;
        }
        if (matchCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    private int countMatchedNumbers(Lotto userLotto, Lotto winningLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();

        return (int) userNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }


}
