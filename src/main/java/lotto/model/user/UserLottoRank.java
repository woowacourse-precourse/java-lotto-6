package lotto.model.user;

import java.util.List;
import lotto.model.lotto.Bonus;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoRank;
import lotto.model.lotto.WinningNumbers;

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
