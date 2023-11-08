package lotto.domain.entity;

import java.util.List;
import java.util.stream.Stream;
import lotto.service.manager.Rank;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> calculateRankings(
            final Lotto target,
            final int bonusNumber)
    {
        return lottos.stream()
                .map(lotto -> convertRank(target, bonusNumber, lotto))
                .filter(rank -> rank != null)
                .toList();
    }

    /**
     * lotto의 Rank을 반환한다
     * @param target 로또 당첨 숫자
     * @param bonusNumber 보너스 숫자
     * @param lotto 등수를 계산할 로또
     * @return lotto의 Rank. 당첨 실패 시 null 반환.
     */
    private Rank convertRank(Lotto target, int bonusNumber, Lotto lotto) {
        int count = lotto.calculateCountOfNumberEqualToWinningNumber(target);
        boolean didHitsBonusNumber = lotto.contain(bonusNumber);
        return Rank.findRank(count, didHitsBonusNumber);
    }

    public Stream<Lotto> stream() {
        return this.lottos.stream();
    }
}
