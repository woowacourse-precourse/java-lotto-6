package lotto.lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.bonus.BonusNumber;
import lotto.ranking.Ranking;

public class LottoPaper {

    private final List<Lotto> lottoPaper;

    public LottoPaper(List<Lotto> lottoPaper) {
        this.lottoPaper = lottoPaper;
    }

    public List<Ranking> calculateRankings(WinningLotto winningLotto, BonusNumber bonusNumber) {
        return lottoPaper.stream().map(lotto -> calculateRanking(lotto, winningLotto, bonusNumber)).toList();
    }

    private Ranking calculateRanking(Lotto lotto, WinningLotto winningLotto, BonusNumber bonusNumber) {
        return Ranking.calculateRanking(getMatchNumberCount(lotto, winningLotto), isBonusMatch(lotto, bonusNumber));
    }

    private boolean isBonusMatch(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.hasBonusNumber(bonusNumber);
    }

    private Integer getMatchNumberCount(Lotto lotto, WinningLotto winningLotto) {
        return winningLotto.getMatchNumberCount(lotto);
    }

    public List<String> getLottoPaperMessage() {
        return lottoPaper.stream().map(Lotto::toString).collect(Collectors.toList());
    }
}
