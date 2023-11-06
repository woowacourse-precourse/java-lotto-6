package lotto.model;

import java.util.List;

public class UserLotto {
    private List<Lotto> lottos;

    public UserLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

}
