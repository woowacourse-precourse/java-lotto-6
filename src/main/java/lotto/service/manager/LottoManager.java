package lotto.service.manager;

import java.util.List;
import java.util.Map;
import lotto.domain.entity.Lotto;
import lotto.domain.entity.Lottos;
import lotto.exception.ExceptionCode;

public class LottoManager {

    private final Lotto target;
    private final RankBoard rankBoard;
    private final int bonusNumber;

    public LottoManager(final Lotto target, final int bonusNumber) {
        validate(bonusNumber);
        this.target = target;
        this.bonusNumber = bonusNumber;
        rankBoard = new RankBoard();
    }

    private void validate(int bonusNumber) {
        if (Lotto.START > bonusNumber || Lotto.END < bonusNumber)
        {
            throw new IllegalArgumentException(
                    ExceptionCode.LOTTO_INVALID_RANGE.getDescription()
            );
        }
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
