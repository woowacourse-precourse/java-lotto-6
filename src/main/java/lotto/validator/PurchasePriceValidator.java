package lotto.validator;

public class PurchasePriceValidator extends Validator {
    @Override
    public void validate(String purchasePrice) {
        purchasePrice = removeSpace(purchasePrice);
        validateOnlyNumber(purchasePrice);
        validatePurchasePriceRange(Integer.parseInt(purchasePrice));
    }
}
