package lotto.model;

import java.util.List;

public class User {
    private final List<Lotto> lottos;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString() + "\n");
        }
        return sb.toString();
    }
}
