package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = lotties;
    }

    public static Lotties generateLottos(int lottoCnt) {
        List<Lotto> lottoies = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            Lotto lotto = LottoFactory.generateLotto();
            lottoies.add(lotto);
        }
        return new Lotties(lottoies);
    }

    public List<List<Integer>> getLotties() {
        List<List<Integer>> lottos = new ArrayList<>();
        for (Lotto lotto : lotties) {
            lottos.add(lotto.getNumbers());
        }
        return Collections.unmodifiableList(lottos);
    }

}


