package lotto.view.inputvalidator;


public class PriceInputValidate extends ValidatorRegistry {
    @Override
    public void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);
        validateAmountIn1000s(userInput);
    }
}
