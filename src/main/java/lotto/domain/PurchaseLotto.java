package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class PurchaseLotto {
    private final List<Lotto> lottos;

    public PurchaseLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PurchaseLotto purchaseAutoLotto(int purchaseCount) {
        List<Lotto> autoLottos = IntStream.rangeClosed(1, purchaseCount)
                .mapToObj(c -> LottoGenerator.autoGenerate())
                .toList();

        return new PurchaseLotto(autoLottos);
    }

    public int getAmount(){
        return this.lottos.size();
    }

}
