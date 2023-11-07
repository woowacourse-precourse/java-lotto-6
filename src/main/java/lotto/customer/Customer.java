package lotto.customer;

import static lotto.validation.Validation.validatePriceDividePossible;
import static lotto.validation.Validation.validatePriceFormat;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.validation.Validation;

public class Customer {
    private int purchaseValue;
    private final List<Lotto> lottoPapers;

    public Customer(String purchaseValue) {
        int purchasePossibleValue = priceToInt(purchaseValue);
        this.purchaseValue = Integer.parseInt(purchaseValue);
        this.lottoPapers = new ArrayList<>();
    }

    private int priceToInt(String purchaseValue) {
        validatePriceFormat(purchaseValue);
        int purchasePossibleValue = Integer.parseInt(purchaseValue);
        validatePriceDividePossible(purchasePossibleValue);

        return purchasePossibleValue;
    }

    public int buy(List<Integer> lotto) {
        this.lottoPapers.add(new Lotto(lotto));
        return this.lottoPapers.size();
    }

    public int getPurchaseValue() {
        return purchaseValue;
    }

    public List<Lotto> getLottoPapers() {
        return lottoPapers;
    }
}
