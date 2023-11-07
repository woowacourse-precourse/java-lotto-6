package lotto.domain;

import lotto.dto.LottoResult;

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

    public LottoResult compareWithWinnerLotto(final WinnerLotto winnerLotto) {
        List<Prize> results = lottos.stream()
                .map(lotto -> lotto.compareWithWinnerLotto(winnerLotto.getWinnerNumbers(), winnerLotto.getBonusNumber()))
                .collect(Collectors.toList());
        return LottoResult.of(results);
    }


    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Integer getCount() {
        return count;
    }


}
