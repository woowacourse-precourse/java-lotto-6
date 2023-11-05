package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<Lotto> lottos;

    private LottoTickets(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTickets generateLottos(List<List<Integer>> generateNumbers) {
        List<Lotto> generateLottos = Collections
                .unmodifiableList(generateNumbers.stream()
                        .map(numbers -> new Lotto(numbers))
                        .collect(Collectors.toList()));


        return new LottoTickets(generateLottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
