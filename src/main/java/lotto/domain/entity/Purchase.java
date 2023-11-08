package lotto.domain.entity;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.ThousandUnitMoney;

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

    public List<List<Integer>> getLottos() {
        return automaticLottos.getLottos();
    }
}
