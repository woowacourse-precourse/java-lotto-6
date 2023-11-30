package view.validator;

public class PurchaseAmountValidator extends Validator{
    public static int validate(String input) {
        validateBlank(input);
        int amount = validateType(input);
        return validateRange(amount, 0);
    }
}
