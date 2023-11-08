package lotto.service;

import java.util.HashSet;
import java.util.List;
import lotto.domain.PurchasedLotto;
import lotto.util.RandomNumberGenerator;

public class LottoPurchaseService {
    public HashSet<PurchasedLotto> purchase(int purchaseAmount) {
        HashSet<PurchasedLotto> purchasedLotto = new HashSet<>();

        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = RandomNumberGenerator.generate();
            purchasedLotto.add(new PurchasedLotto(numbers));
        }

        return purchasedLotto;
    }
}
