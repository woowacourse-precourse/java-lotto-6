package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<List<Integer>> numbers) {
        this.lottos = numbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(this.lottos);
    }
}
