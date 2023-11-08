package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            Lotto newLotto = new Lotto(NumberGenerator.generateNumbers());
            lottos.add(newLotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
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
