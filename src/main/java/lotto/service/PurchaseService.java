package lotto.service;

import lotto.model.domain.Purchase;
import lotto.model.domain.PurchaseValidator;

public class PurchaseService {
    private final PurchaseValidator validator = new PurchaseValidator();

    public Purchase getPurchaseIfValid(String input) {
        try {
            int priceInteger = validator.validateIntegerInput(input);
            int lottoCount = validator.validatePriceInThousandUnit(priceInteger);
            return new Purchase(priceInteger, lottoCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
