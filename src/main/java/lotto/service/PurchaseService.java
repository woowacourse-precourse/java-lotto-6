package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchaseRepository;
import lotto.utils.RandomNumberGenerator;
import lotto.validator.LottoPurchaseValidator;

import java.util.List;

// TODO: 로또 생성 전략을 Interface로
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
