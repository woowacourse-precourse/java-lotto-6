package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> lottos;

    public PurchasedLottos(PurchaseAmount purchaseAmount) {
        this.lottos = generateLottos(purchaseAmount.getLottoCount());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> generateLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>();

        while (count > 0) {
            lottoList.add(generateSingleLotto());
            count--;
        }

        return lottoList;
    }

    private Lotto generateSingleLotto() {
        return new Lotto(new LottoGenerator().getRandomNumbers());
    }
}
