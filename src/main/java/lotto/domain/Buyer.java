package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.BuyerValidator;

public class Buyer {
    private final int purchasePrice;
    private final int lottoQuantity;
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> purchaseLotteries = new ArrayList<>();

    public Buyer(int purchasePrice) {
        BuyerValidator.validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
        this.lottoQuantity = purchasePrice / LOTTO_PRICE;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }

    public List<Lotto> getPurchaseLotteries() {
        return purchaseLotteries;
    }

    public void addPurchaseLotto(Lotto purchaseLotto) {
        purchaseLotteries.add(purchaseLotto);
    }

}
