package lotto.domain.db;

import java.util.List;

public class PurchaseLottoCollection {
    private List<PurchaseLotto> purchaseLottos;

    public PurchaseLottoCollection(List<PurchaseLotto> purchaseLottos) {
        this.purchaseLottos = purchaseLottos;
    }

    public List<PurchaseLotto> getPurchaseLottos() {
        return purchaseLottos;
    }
}
