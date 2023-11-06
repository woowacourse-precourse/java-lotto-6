package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(lotto -> lotto.toString() + "\n")
                .collect(Collectors.joining());
    }

    public int getSize() {
        return lottos.size();
    }
}
