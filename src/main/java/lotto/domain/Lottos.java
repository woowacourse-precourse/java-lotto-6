package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;
    private final Integer count;

    private Lottos(final List<Lotto> lottoDummy) {
        this.lottos = lottoDummy;
        this.count = lottos.size();
    }


    public static Lottos create(final List<Lotto> lottoDummy) {
        return new Lottos(lottoDummy);
    }

    private List<Prize> compareWithWinnerLotto(final WinnerLotto winnerLotto) {
        return lottos.stream()
                .map(lotto -> lotto.compareWithWinnerLotto(winnerLotto.getWinnerNumbers(),
                        winnerLotto.getBonusNumber()))
                .collect(Collectors.toList());
    }


    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Integer getCount() {
        return count;
    }


}
