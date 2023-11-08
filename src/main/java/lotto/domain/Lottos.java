package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return lottos.stream()
            .map(lotto -> lotto.toString().concat("\n"))
            .collect(Collectors.joining());
    }
}
