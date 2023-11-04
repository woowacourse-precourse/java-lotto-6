package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.LottoConstant;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(LottoConstant.NEW_LINE.get()));
    }
}
