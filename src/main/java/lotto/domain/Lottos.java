package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> allLottos;

    public Lottos(List<Lotto> allLottos) {
        this.allLottos = allLottos;
    }

    @Override
    public String toString() {
        return allLottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}