package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = lotties;
    }

    public List<Lotto> getLotties() {
        return Collections.unmodifiableList(lotties);
    }

    public List<List<Integer>> getLottiesNumbers() {
        List<List<Integer>> lottos = new ArrayList<>();
        for (Lotto lotto : lotties) {
            lottos.add(lotto.getNumbers());
        }
        return Collections.unmodifiableList(lottos);
    }
}



