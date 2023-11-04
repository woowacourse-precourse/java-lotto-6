package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Values;
import lotto.utils.RandomNumberGenerator;

public class PurchasedLottos {

    private final List<Lotto> lottos;

    public PurchasedLottos(int purchaseAmount) {
        this.lottos = createPurchasedLottos(purchaseAmount);
    }

    private List<Lotto> createPurchasedLottos(int purchaseAmount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        int numberOfLottosToPurchase = purchaseAmount / Values.LOTTO_PURCHASE_UNIT;
        for (int i = 0; i < numberOfLottosToPurchase; i++) {
            Lotto lotto = new Lotto(RandomNumberGenerator.generateRandomNumbers());
            purchasedLottos.add(lotto);
        }
        return purchasedLottos;
    }
}
