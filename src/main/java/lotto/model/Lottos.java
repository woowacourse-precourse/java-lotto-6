package lotto.model;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos getInstance(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public String getLottos() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.getLottoNumbers());
        }
        return sb.toString();
    }
}
