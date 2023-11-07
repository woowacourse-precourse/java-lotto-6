package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseInfo {
    int purchaseAmount;
    int purchaseLottoNum;
    private final List<Lotto> lottos;

    public LottoPurchaseInfo(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseLottoNum = purchaseAmount / 1000;
        this.lottos = new ArrayList<>();
        for (int i = 0; i < purchaseLottoNum; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public int getPurchaseLottoNum() {
        return this.purchaseLottoNum;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
