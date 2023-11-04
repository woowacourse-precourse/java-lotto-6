package lotto.domain;

import lotto.utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.utils.PurchaseManager.dividePurchaseAmount;

public class PurchasedLotto {

    private List<Lotto> purchasedLotto;

    public void issueLotto(int purchaseAmount) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        IntStream.range(0, dividePurchaseAmount(purchaseAmount))
                .forEach(i -> purchasedLotto.add(new Lotto(randomNumberGenerator.generateNumber())));
    }

}
