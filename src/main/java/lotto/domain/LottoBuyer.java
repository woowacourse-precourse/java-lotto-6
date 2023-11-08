package lotto.domain;

import java.util.ArrayList;

public class LottoBuyer {

    private static final int MINIMUM_LOTTO_AMOUNT = 1000;

    private final int purchaseAmount;

    private final ArrayList<Lotto> purchaseLottos = new ArrayList<>();

    public LottoBuyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void purchaseLotto(Lotto lotto) {
        purchaseLottos.add(lotto);
    }

    public int purchaseCount() {
        return purchaseAmount / MINIMUM_LOTTO_AMOUNT;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public ArrayList<Lotto> getPurchaseLottos() {
        return purchaseLottos;
    }
}
