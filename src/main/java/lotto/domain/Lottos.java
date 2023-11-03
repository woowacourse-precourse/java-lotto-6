package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Result getResult(final WinnerNumbers winnerNumbers) {
        final List<Prize> prizes = lottos.stream().map(lotto -> lotto.getPrize(winnerNumbers)).toList();
        return new Result(prizes);
    }
}
