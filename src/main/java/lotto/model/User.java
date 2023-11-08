package lotto.model;

import java.util.List;

public class User {
    private final int count;
    private final List<Lotto> lottos;

    public User(int count, List<Lotto> lottos) {
        this.count = count;
        this.lottos = lottos;
    }

    public int getCount() {
        return count;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
