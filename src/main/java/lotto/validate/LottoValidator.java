package lotto.validate;

public class LottoValidator extends Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateNaturalNumber(input);
        validateLottoRange(input);
    }
}
