package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    int purchaseCost;
    List<Lotto> lottos = new ArrayList<>();
    List<Integer> winningStatics = new ArrayList<>();

    public int getPurchaseCost() {
        return purchaseCost;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Lotto> purchaseLotto(int purchaseCostInput) {
        purchaseCost = purchaseCostInput;
        int lottoQuantity = Lotto.calculatePurchaseQuantity(purchaseCostInput);

        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(Lotto.issue());
        }
        return lottos;
    }
}
