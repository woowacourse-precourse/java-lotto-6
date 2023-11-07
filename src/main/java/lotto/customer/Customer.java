package lotto.customer;

import static lotto.validation.PurchaseValidation.validatePriceDividePossible;
import static lotto.validation.PurchaseValidation.validatePriceFormat;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class Customer {
    private int purchaseValue;
    private final List<Lotto> lottos;

    public Customer(String purchaseValue) {
        int purchasePossibleValue = priceToInt(purchaseValue);
        this.purchaseValue = purchasePossibleValue;
        this.lottos = new ArrayList<>();
    }

    private int priceToInt(String purchaseValue) {
        validatePriceFormat(purchaseValue);
        int purchasePossibleValue = Integer.parseInt(purchaseValue);
        validatePriceDividePossible(purchasePossibleValue);

        return purchasePossibleValue;
    }

    public int buy(Lotto lotto) {
        this.lottos.add(lotto);
        return this.lottos.size();
    }

    public int getPurchaseValue() {
        return this.purchaseValue;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int getLottoSize() {
        return this.lottos.size();
    }
}
