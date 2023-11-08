package lotto.domain.entity;

import java.util.List;
import java.util.Map;

public class LottoManager {

    private final Lotto target;
    private final RankBoard rankBoard;
    private final int bonusNumber;

    public LottoManager(final Lotto target, final int bonusNumber) {
        this.target = target;
        this.bonusNumber = bonusNumber;
        rankBoard = new RankBoard();
    }

    public void calculateTotalRanking(final Lottos lottos) {
        List<Rank> ranks = lottos.calculateRankings(target, bonusNumber);
        rankBoard.note(ranks);
    }

    public Map<Rank, Long> getRankBoard() {
        return rankBoard.getResultBoard();
    }

    public long getTotalPrize() {
        return rankBoard.getTotalPrize();
    }
}
