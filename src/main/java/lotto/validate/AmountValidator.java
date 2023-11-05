package lotto.validate;

public class AmountValidator extends Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateNaturalNumber(input);
        validateIntRange(input);
        validateDivisibleByThousand(input);
    }
}
