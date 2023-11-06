package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;
    private final Integer count;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
        this.count = lottos.size();
    }

    public Prizes createPrizes(final List<Integer> winnerNumbers, final Integer bonusNumber) {
        final List<Prize> prizes = compareAllLottoWithWinnerLotto(winnerNumbers, bonusNumber);
        return new Prizes(prizes);
    }
    private List<Prize> compareAllLottoWithWinnerLotto(final List<Integer> winnerNumbers, final Integer bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.compareWithWinnerLotto(winnerNumbers, bonusNumber))
                .collect(Collectors.toList());
    }


    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Integer getCount() {
        return count;
    }


}
