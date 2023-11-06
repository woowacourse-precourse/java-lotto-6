package lotto.util.validator;

public class AmountValidator extends Validator{
    @Override
    public void validation(String input) {
        validationNumeric(input);

    }


    private void validationNumeric(String input) {
        String regex = "^[0-9]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}
