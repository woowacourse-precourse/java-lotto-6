package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public int getSize() {
        return lottos.size();
    }
}
