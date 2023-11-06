package lotto.model;

import java.util.ArrayList;

public class Buyer {
    private Integer purchasedLottoCount;
    private ArrayList<Lotto> purchasedLottoList = new ArrayList<>();

    public void setPurchasedLottoCount(int purchasedLottoCount) {
        this.purchasedLottoCount = purchasedLottoCount;
    }

    public void addPurchasedLottoList(Lotto lotto) {
        purchasedLottoList.add(lotto);
    }

    public ArrayList<Lotto> getPurchasedLottoList() {
        return this.purchasedLottoList;
    }
}
