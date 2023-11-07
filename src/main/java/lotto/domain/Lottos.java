package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final int count;
    private final List<Lotto> lottos;

    public Lottos(int count) {
        this.count = count;
        this.lottos = new ArrayList<>();
        createLottos(count);
    }

    private void createLottos(int count) {
        for(int i = 0; i < count; i++){


        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
