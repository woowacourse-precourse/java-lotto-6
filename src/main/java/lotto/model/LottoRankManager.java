package lotto.model;

import java.util.List;

public class LottoRankManager {
    public static List<LottoRank> findLottoRanks(List<Lotto> lottos, WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> findLottoRank(lotto, winningNumbers))
                .toList();
    }

    private static LottoRank findLottoRank(Lotto lotto, WinningNumbers winningNumbers) {
        return LottoRank.of(findMatchCount(lotto, winningNumbers), isBonusMatch(lotto, winningNumbers.getBonus()));
    }

    private static int findMatchCount(Lotto lotto, WinningNumbers winningNumbers) {
        return winningNumbers.getMatchCount(lotto);
    }

    private static boolean isBonusMatch(Lotto lotto, Bonus bonus) {
        return lotto.getNumbers().contains(bonus.getNumber());
    }
}
