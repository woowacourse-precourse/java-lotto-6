package lotto.service.manager;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.exception.ExceptionCode;

public class LottoManager {

    private final Lotto target;
    private final RankBoard rankBoard;
    private final int bonusNumber;

    public LottoManager(final Lotto target, final int bonusNumber) {
        validateRange(bonusNumber);
        validateContain(target, bonusNumber);
        this.target = target;
        this.bonusNumber = bonusNumber;
        rankBoard = new RankBoard();
    }

    private void validateRange(final int bonusNumber) {
        if (Lotto.START > bonusNumber || Lotto.END < bonusNumber)
        {
            throw new IllegalArgumentException(
                    ExceptionCode.LOTTO_INVALID_RANGE.getDescription()
            );
        }
    }

    private void validateContain(final Lotto target, final int bonusNumber) {
        if (target.contain(bonusNumber)) {
            throw new IllegalArgumentException(
                    ExceptionCode.BONUS_NUMBER_CONTAINED.getDescription()
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
