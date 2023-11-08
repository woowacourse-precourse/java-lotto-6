package lotto.service;

import java.util.List;
import lotto.dto.Lotto;
import lotto.repository.PurchaseRepository;
import lotto.utils.RandomNumberGenerator;
import lotto.validator.LottoPurchaseValidator;

public class PurchaseService {
    private static PurchaseRepository purchaseRepository = PurchaseRepository.getInstance();

    public int getCountOfPurchasable(int amount) {
        LottoPurchaseValidator.validatePurchase(amount);
        return amount / 1000;
    }

    public List<Lotto> purchaseLottoForCount(int count) {
        for (int i = 0; i < count; i++) {
            purchaseRepository.recordPurchase(generateEachLotto());
        }
        return purchaseRepository.findLottos();
    }

    private Lotto generateEachLotto() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        return new Lotto(generator.generateNumbers());
    }
}
