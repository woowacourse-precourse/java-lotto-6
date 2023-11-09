package lotto.service;

import java.util.Comparator;
import lotto.domain.Purchases;
import lotto.dto.Lotto;
import lotto.dto.Lottos;
import lotto.utils.RandomNumberGenerator;
import lotto.validator.LottoPurchaseValidator;

public class PurchaseService {
    private Purchases purchases = new Purchases();

    public int getCountOfPurchasable(int amount) {
        LottoPurchaseValidator.validatePurchase(amount);
        return amount / 1000;
    }

    public Lottos purchaseLottoForCount(int count) {
        for (int i = 0; i < count; i++) {
            purchases.recordPurchase(generateEachLotto());
        }
        return purchases.findLottos();
    }

    private Lotto generateEachLotto() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        return new Lotto(generator.generateNumbers().stream()
                .sorted(Comparator.naturalOrder())
                .toList());
    }

    public int size() {
        return purchases.size();
    }
}
