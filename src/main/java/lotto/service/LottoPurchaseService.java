package lotto.service;

import java.util.HashSet;
import java.util.List;
import lotto.Lotto;
import lotto.util.RandomNumberGenerator;

public class LottoPurchaseService {
    public HashSet<Lotto> purchase(int purchaseAmount) {
        HashSet<Lotto> purchasedLotto = new HashSet<>();

        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = RandomNumberGenerator.generate();
            purchasedLotto.add(new Lotto(numbers));
        }

        return purchasedLotto;
    }
}
