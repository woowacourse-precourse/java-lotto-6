package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatchLotto {

    public static MatchLotto createMatchLotto() {
        return new MatchLotto();
    }

    public List<LottoRankings> matchLotto(List<Integer> winningNumbers, int bonusNumber,
                                          List<Lotto> lottoPurchaseHistory) {
        List<LottoRankings> matchResult = new ArrayList<>();
        for (Lotto lotto : lottoPurchaseHistory) {
            int match = matchWinningNumber(winningNumbers, lotto);
            boolean bonus = matchBonusNumber(lotto.getNumbers(), bonusNumber);
            matchResult.add(findRank(match, bonus));
        }
        return matchResult;
    }

    private static LottoRankings findRank(int match, boolean bonus) {
        return Arrays.stream(LottoRankings.values())
                .filter(rank -> rank.getMatch() == match)
                .filter(rank -> rank.getBonus().contains(bonus))
                .findAny().orElse(LottoRankings.NONE);
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
}
