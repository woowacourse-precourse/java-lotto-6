package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.dto.PurchaseAmountDto;
import lotto.util.RandomNumberGenerator;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(final PurchaseAmountDto purchaseAmountDto) {
        int purchase_Quantity = purchaseAmountDto.purchaseQuantityLottos();

        for (int quantity = 0; quantity < purchase_Quantity; quantity++) {
            List<Integer> numbers = RandomNumberGenerator.generate();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
