package lotto.model;

import java.util.List;

public class UserLottoRank {
    private final List<LottoRank> lottoRanks;

    public UserLottoRank(UserLotto userLotto, WinningNumbers winningNumbers) {
        this.lottoRanks = userLotto.getLottos().stream()
                .map(lotto -> findLottoRank(lotto, winningNumbers))
                .toList();
    }

    public long getRevenue() {
        return lottoRanks.stream()
                .mapToLong(LottoRank::getPrize)
                .sum();
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }

    private LottoRank findLottoRank(Lotto lotto, WinningNumbers winningNumbers) {
        return LottoRank.of(findMatchCount(lotto, winningNumbers), isBonusMatch(lotto, winningNumbers.getBonus()));
    }

    private int findMatchCount(Lotto lotto, WinningNumbers winningNumbers) {
        return winningNumbers.getMatchCount(lotto);
    }

    private boolean isBonusMatch(Lotto lotto, Bonus bonus) {
        return lotto.getNumbers().contains(bonus.getNumber());
    }
}
