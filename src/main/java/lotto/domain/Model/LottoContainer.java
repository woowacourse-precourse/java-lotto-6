package lotto.domain.Model;

import java.util.ArrayList;
import java.util.List;

public class LottoContainer {

    private final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
