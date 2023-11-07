package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.BuyerValidator;

public class Buyer {
    private final int purchasePrice;
    private List<Lotto> purchaseLotteries = new ArrayList<>();

    public Buyer(int purchasePrice) {
        BuyerValidator.validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getPurchaseLotteries() {
        return purchaseLotteries;
    }

}
