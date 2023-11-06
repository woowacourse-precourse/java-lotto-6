package lotto.domain;

import java.util.List;
import java.util.StringJoiner;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");
        for (Lotto lotto : lottos) {
            sj.add(lotto.toString());
        }
        return sj.toString();
    }
}