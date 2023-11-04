package lotto.domain;

import lotto.utils.numbergenerators.NumberGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.utils.PurchaseManager.dividePurchaseAmount;

public class PurchasedLotto {

    private List<Lotto> purchasedLotto;

    public List<Lotto> issueLotto(int purchaseAmount, NumberGenerator numberGenerator) {
        return IntStream.range(0, dividePurchaseAmount(purchaseAmount))
                .mapToObj(i -> new Lotto(numberGenerator.generateNumber()))
                .toList();
    }

}
