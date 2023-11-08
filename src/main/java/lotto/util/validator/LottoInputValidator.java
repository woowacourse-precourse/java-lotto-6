package lotto.util.validator;

public class LottoInputValidator implements InputValidator{
    @Override
    public void validate(String checkValue) {

    }

    private static void validateCount(String[] checkValues) {
        if(checkValues.length != 6) {
            throw new IllegalArgumentException();
        }
    }
}
