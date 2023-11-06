package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> getLottosNumber() {
        return lottos.stream()
                .map(Lotto::getNumberValues)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
