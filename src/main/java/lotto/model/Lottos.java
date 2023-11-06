package lotto.model;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public String getLottosNumbers() {
        StringBuilder result = new StringBuilder();

        for (Lotto lotto : lottos) {
            result.append(lotto.getLottoNumbers())
                    .append("\n");
        }

        return result.toString();
    }
}
