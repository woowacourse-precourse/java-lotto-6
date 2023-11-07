package lotto.validate;

public class WinningLottoValidator extends Validator {
    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateNaturalNumber(input);
        validateLottoRange(input);
    }
}
