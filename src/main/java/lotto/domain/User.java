package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final Integer cash;
    private final List<Lotto> lottos;

    public User(List<Lotto> lottos, Integer cash) {
        this.lottos = lottos;
        this.cash = cash;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(lotto -> lotto.toString() + "\n")
                .collect(Collectors.joining());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
