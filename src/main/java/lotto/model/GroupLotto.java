package lotto.model;

import java.util.List;

public class GroupLotto {
    private final List<Lotto> lottos;

    public GroupLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
