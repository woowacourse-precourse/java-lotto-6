package lotto.domain;

import lotto.utils.numbergenerators.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.utils.PurchaseManager.dividePurchaseAmount;

public class PurchasedLotto {

    private static final int ISSUE_START_VALUE = 0;
    private final List<Lotto> purchasedLotto;

    private PurchasedLotto(int purchaseAmount, NumberGenerator numberGenerator) {
        purchasedLotto = issueLotto(purchaseAmount, numberGenerator);
    }

    public static PurchasedLotto of(int purchaseAmount, NumberGenerator numberGenerator) {
        return new PurchasedLotto(purchaseAmount, numberGenerator);
    }

    private List<Lotto> issueLotto(int purchaseAmount, NumberGenerator numberGenerator) {
        return IntStream.range(ISSUE_START_VALUE, dividePurchaseAmount(purchaseAmount))
                .mapToObj(i -> new Lotto(numberGenerator.generateNumber()))
                .toList();
    }

    public List<Lotto> getPurchasedLotto() {
        return Collections.unmodifiableList(purchasedLotto);
    }
}
