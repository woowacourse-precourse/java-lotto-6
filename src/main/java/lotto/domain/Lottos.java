package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomNumberGenerator;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(final PurchaseAmount purchaseAmount) {
        int purchase_Quantity = purchaseAmount.purchaseQuantityLottos();

        for (int quantity = 0; quantity < purchase_Quantity; quantity++) {
            List<Integer> numbers = RandomNumberGenerator.generate();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public Lottos(final List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
