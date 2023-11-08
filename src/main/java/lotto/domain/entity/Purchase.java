package lotto.domain.entity;

import java.util.List;

public class Purchase {
    private final ThousandUnitMoney purchaseAmount;
    private final Lottos automaticLottos;

    private Purchase(ThousandUnitMoney purchaseAmount, Lottos automaticLottos) {
        this.purchaseAmount = purchaseAmount;
        this.automaticLottos = automaticLottos;

    }

    public static Purchase create(ThousandUnitMoney purchaseAmount, Lottos automaticLottos) {
        return new Purchase(purchaseAmount, automaticLottos);
    }

    public ThousandUnitMoney getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<List<Integer>> getLottosByDoubleList() {
        return automaticLottos.getLottosByDoubleList();
    }

    public List<Lotto> getLottosByLottoList() {
        return automaticLottos.getLottosByLottoList();
    }
}
