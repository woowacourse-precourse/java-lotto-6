package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos.stream()
                .map(Lottos::getLotto)
                .collect(Collectors.toUnmodifiableList());
    }

    private static Lotto getLotto(Lotto lotto) {
        return new Lotto(
                lotto.getNumbers().stream()
                        .map(LottoNumber::getNumber)
                        .collect(Collectors.toUnmodifiableList())
        );
    }
}
