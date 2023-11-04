package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottosDTO toLottosDTO() {
        return new LottosDTO(lottos.stream()
                .map(Lotto::getLotto)
                .collect(Collectors.toList()));
    }
}
