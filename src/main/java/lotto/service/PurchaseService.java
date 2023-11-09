package lotto.service;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.ZERO;

import java.util.Comparator;
import java.util.stream.IntStream;
import lotto.domain.Purchases;
import lotto.dto.Lotto;
import lotto.dto.Lottos;
import lotto.utils.RandomNumberGenerator;
import lotto.validator.LottoPurchaseValidator;

public class PurchaseService {
    private Purchases purchases = new Purchases();

    public int getCountOfPurchasable(int amount) {
        LottoPurchaseValidator.validatePurchase(amount);
        return amount / LOTTO_PRICE;
    }

    public Lottos purchaseLottoForCount(int count) {
        IntStream.range(ZERO, count).forEach(i -> purchases.recordPurchase(generateEachLotto()));
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
