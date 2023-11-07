package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<List<Integer>> numbers) {
        this.lotties = numbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public List<Lotto> getLotties() {
        return new ArrayList<>(this.lotties);
    }
}
