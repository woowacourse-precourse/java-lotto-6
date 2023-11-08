package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Result getResult(WinningLotto winningLotto) {
        Result result = new Result();

        lottos.forEach(lotto -> {
                int matchCount = lotto.getMatchCount(winningLotto.getLotto());
                boolean containBonusNumber = lotto.isContainBonusNumber(winningLotto.getBonusNumber());
                result.increaseRankCount(matchCount, containBonusNumber);
            });

        return result;
    }
}
