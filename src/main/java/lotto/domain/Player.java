package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private long price;
    private final List<Lotto> purchasedLotto = new ArrayList<>();

    public void addLottoInPurchasedLotto(Lotto lotto) {
        this.purchasedLotto.add(lotto);
    }

    public long getPrice() {
        return this.price;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    public void setPrice(long price) {
        this.price = price;
    }

}
