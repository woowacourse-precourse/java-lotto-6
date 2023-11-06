package lotto.validator;

public class BonusNumberValidator extends Validator {
    @Override
    public void validate(String input) {
        input = removeSpace(input);
        validateOnlyNumber(input);
        validateLottoRange(Integer.parseInt(input));
    }
}
