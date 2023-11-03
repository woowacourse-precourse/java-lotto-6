package lotto.view.valid;

public class BuyingPriceValidation implements InputValidation<Integer> {

    private final ViewValidator viewValidator;

    public BuyingPriceValidation(final ViewValidator viewValidator) {
        this.viewValidator = viewValidator;
    }

    @Override
    public Integer validateInput(final String buyingPriceText) {
        int buyingPrice = viewValidator.parseInt(buyingPriceText);
        viewValidator.validateMod(buyingPrice);
        return buyingPrice;
    }
}
