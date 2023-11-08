package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class Lottos {

    private List<Lotto> lottoCollection;

    public Lottos(List<Lotto> lottoCollection) {
        this.lottoCollection = lottoCollection;
    }

    public static Lottos createLottos(Money money) {
        List<Lotto> lottoCollection = new ArrayList<>();
        int lottoNum = money.getMoney() / Money.UNIT_PRICE;
        for (int i = 0; i < lottoNum; i++) {
            lottoCollection.add(Lotto.createLotto());
        }
        return new Lottos(lottoCollection);
    }

    public List<Lotto> getLottoCollection() {
        return lottoCollection;
    }
}
