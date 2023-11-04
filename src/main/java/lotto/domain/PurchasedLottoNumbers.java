package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class PurchasedLottoNumbers {
    private final List<Lotto> purchasedLotto;

    public PurchasedLottoNumbers(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
