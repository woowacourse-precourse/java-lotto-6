package lotto.model;

import java.util.ArrayList;

public class Buyer {
    private final Integer purchasedLottoCount;
    private ArrayList<Lotto> purchasedLottoList = new ArrayList<>();

    public Buyer(Integer purchasedLottoCount) {
        this.purchasedLottoCount = purchasedLottoCount;
    }

    public void addPurchasedLottoList(Lotto lotto) {
        purchasedLottoList.add(lotto);
    }

    public ArrayList<Lotto> getPurchasedLottoList() {
        return this.purchasedLottoList;
    }
}
