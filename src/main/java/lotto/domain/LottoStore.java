package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.NumberGenerator;
import lotto.domain.lotto.RandomNumberGenerator;

public class LottoStore {

    private final List<Lotto> issuedLotto;
    private final PurchaseCount purchaseCount;

    public LottoStore(int purchaseAmount) {
        this.issuedLotto = new ArrayList<>();
        this.purchaseCount = new PurchaseCount(purchaseAmount);
    }

    public void issueLotto() {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        purchaseCount.decrement();
        issuedLotto.add(new Lotto(randomNumberGenerator.generateNumbers()));
    }

    public List<Lotto> getIssuedLotto() {
        return Collections.unmodifiableList(issuedLotto);
    }

    public boolean isOpen() {
        return purchaseCount.hasRemain();
    }

}
