package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final Long cash;
    private final List<Lotto> lottos;

    public User(List<Lotto> lottos, Long cash) {
        this.lottos = lottos;
        this.cash = cash;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Long getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(lotto -> lotto.toString() + "\n")
                .collect(Collectors.joining());
    }
}
