package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.common.utils.RandomNumberGenerator;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> purchase(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount.getQuantity(LOTTO_PRICE); i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(RandomNumberGenerator
                .generateUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, Lotto.LOTTO_SIZE));
    }
}
