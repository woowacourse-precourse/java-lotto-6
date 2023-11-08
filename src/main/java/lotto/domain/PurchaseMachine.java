package lotto.domain;

import lotto.utils.RandomNumberGenerator;
import lotto.validator.LottoPurchaseValidator;

import java.util.List;

// TODO: 로또 생성 전략을 Interface로
public class PurchaseMachine {
    private static PurchaseRepository purchaseRepository = PurchaseRepository.getInstance();

    // TODO: 숫자가 아닌경우, INPUTVIEW에서 예외처리
    public static int getCountOfPurchasable(int amount) {
        LottoPurchaseValidator.validatePurchase(amount);
        return amount / 1000;
    }

    public static List<Lotto> purchaseLottoForCount(int count) {
        for (int i = 0; i < count; i++) {
            purchaseRepository.recordPurchase(generateEachLotto());
        }
        return purchaseRepository.findLottos();
    }

    private static Lotto generateEachLotto() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        return new Lotto(generator.generateNumbers());
    }
}
