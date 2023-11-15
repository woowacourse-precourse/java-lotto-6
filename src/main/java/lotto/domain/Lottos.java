package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();

    public Lottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            Lotto newLotto = new Lotto(NumberGenerator.generateNumbers());
            lottoList.add(newLotto);
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoList.forEach(lotto -> {
            stringBuilder.append(lotto);
            stringBuilder.append("\n");
        });
        return stringBuilder.toString();
    }
}
