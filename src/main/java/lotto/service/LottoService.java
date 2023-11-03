package lotto.service;

import lotto.domain.PurchasePrice;
import lotto.view.Input;

public class LottoService {

    public PurchasePrice createPurchasePrice(Input input) {
        try {
            return PurchasePrice.from(input.purchasePrice());
        } catch (IllegalArgumentException e) {
            return createPurchasePrice(input);
        }
    }
}
