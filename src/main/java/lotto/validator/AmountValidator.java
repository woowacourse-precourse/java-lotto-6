package lotto.validator;

public class AmountValidator implements Validator {
    @Override
    public void validate(String input) {
        throw new IllegalArgumentException();
    }
}
