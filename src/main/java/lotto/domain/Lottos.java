package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottos.forEach(lotto -> {
            stringBuilder.append(lotto);
            stringBuilder.append("\n");
        });

        return stringBuilder.toString();
    }
}
