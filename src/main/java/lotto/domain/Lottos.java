package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;
    private final Integer count;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        this.count = lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Integer getCount() {
        return count;
    }

    public List<Prize> compareAllLottoWithWinnerLotto(List<Integer> winnerNumbers, Integer bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.compareWithWinnerLotto(winnerNumbers, bonusNumber))
                .collect(Collectors.toList());
    }

    public Prizes createPrizes(List<Prize> prizes) {
        return new Prizes(prizes);
    }

}
