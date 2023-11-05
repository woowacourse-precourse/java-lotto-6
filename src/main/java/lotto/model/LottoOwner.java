package lotto.model;

import lotto.dto.LottosInfo;

public class LottoOwner {
    private final PurchasePrice purchasePrice;
    private final Lottos lottos;

    private LottoOwner(PurchasePrice purchasePrice, Lottos lottos) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
    }

    public static LottoOwner of(PurchasePrice purchasePrice, Lottos lottos) {
        return new LottoOwner(purchasePrice, lottos);
    }

    public LottosInfo getLottoInfos() {
        return lottos.getLottosInfo();
    }
}
