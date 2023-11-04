package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Map<LottoRank, Long> countLottoRanks(final Lotto winningLotto, final int bonus) {
        return lottos.stream()
                .map(lotto -> lotto.determineLottoRank(winningLotto, bonus))
                .collect(Collectors.groupingBy(
                        rank -> rank,
                        Collectors.counting()
                ));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
