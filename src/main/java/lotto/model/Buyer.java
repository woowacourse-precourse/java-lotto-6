package lotto.model;

import java.util.ArrayList;

public class Buyer {
    private final int purchasedLottoCount;
    private final ArrayList<Lotto> purchasedLotto = new ArrayList<>();

    public Buyer(Integer purchasedLottoCount) {
        this.purchasedLottoCount = purchasedLottoCount;
    }

    public int getPurchasedLottoCount() {
        return this.purchasedLottoCount;
    }

    public void addPurchasedLottoList(Lotto lotto) {
        purchasedLotto.add(lotto);
    }

    public ArrayList<Lotto> getPurchasedLotto() {
        return this.purchasedLotto;
    }
}
