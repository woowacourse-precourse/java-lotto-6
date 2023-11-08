package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private final List<Lotto> purchasedLottos;

    Customer(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public static Customer of(LottoPurchaseAmount purchaseAmount, LottoFactory factory) {
        List<Lotto> purchasedLottos = purchaseLotto(purchaseAmount, factory);
        return new Customer(purchasedLottos);
    }

    private static List<Lotto> purchaseLotto(LottoPurchaseAmount purchaseAmount, LottoFactory factory) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0, purchaseAmountValue = purchaseAmount.value(); i < purchaseAmountValue; i++) {
            purchasedLottos.add(factory.create());
        }
        return purchasedLottos;
    }

    public List<Lotto> purchasedLottos() {
        return Collections.unmodifiableList(purchasedLottos);
    }
}
