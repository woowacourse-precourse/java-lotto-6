package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getPriceSum(WinningLotto winningLotto) {
        return lottos.stream()
            .map(winningLotto::match)
            .mapToInt(Rank::getWinningMoney)
            .sum();
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
