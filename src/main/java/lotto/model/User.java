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

    public List<Lotto> getLotto()  {
        return lottos;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString() + "\n");
        }
        return stringBuilder.toString();
    }
}
