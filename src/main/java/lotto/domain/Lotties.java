package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = lotties;
    }

    public String getLottiesStatus() {
        StringJoiner joiner = new StringJoiner("\n");
        for (Lotto lotto : lotties) {
            joiner.add(lotto.toString());
        }

        return joiner.toString();
    }

    public List<Lotto> getLotties() {
        return new ArrayList<>(lotties);
    }
}
