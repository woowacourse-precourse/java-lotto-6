package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final long price;
    private final List<Lotto> purchasedLotto = new ArrayList<>();

    public Player(long price) {
        this.price = price;
    }

    public void addLottoInPurchasedLotto(Lotto lotto) {
        this.purchasedLotto.add(lotto);
    }

    public long getPrice() {
        return this.price;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

}
