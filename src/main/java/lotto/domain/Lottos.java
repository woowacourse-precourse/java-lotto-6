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

    public Prizes createPrizes(List<Integer> winnerNumbers, Integer bonusNumber) {
        List<Prize> prizes = compareAllLottoWithWinnerLotto(winnerNumbers, bonusNumber);
        return new Prizes(prizes);
    }
    private List<Prize> compareAllLottoWithWinnerLotto(List<Integer> winnerNumbers, Integer bonusNumber) {
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
