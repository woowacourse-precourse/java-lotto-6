package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public List<Lotto> getLottosDTO() {
        return Collections.unmodifiableList(lottos);
    }
}
