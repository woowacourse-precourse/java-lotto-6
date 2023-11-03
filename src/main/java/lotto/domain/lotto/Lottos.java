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

    //보너스도 체크해야 한다.
    public Map<Integer,Long> getLottoMatchCountMap(final Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.lottoMatchValue(winningLotto))
                .collect(Collectors.groupingBy(
                        count -> count,
                        Collectors.counting()
                ));
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

}
