package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private static final int LOTTO_PRICE = 1_000;

    private final int purchaseAmount;
    private final List<Lotto> lottoList = new ArrayList<>();

    public Buyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        purchaseLotto();
    }

    private void purchaseLotto() {
        for (int i = 0; i < purchaseAmount / LOTTO_PRICE; i++) {
            lottoList.add(LottoOffice.generateLotto());
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getNumberOfLotto() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
