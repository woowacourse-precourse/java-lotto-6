package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Util.LottoGenerator;

public class Lotties {

    private List<Lotto> lotties;

    public Lotties(int count) {
        lotties = new ArrayList<>();
        int nowCount = 1;
        do {
            Lotto lotto = LottoGenerator.generate();
            lotto.sortNumbers();
            lotties.add(lotto);
        } while (nowCount++ < count);
    }

    public List<Lotto> getLotties() {
        return lotties;
    }
}
