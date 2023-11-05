package lotto.validation;

public class LottoCountValidator implements InputValidator {
    public void validate(String input) {
        if (!isInteger(input)) {
            Error error = Error.INTEGER_ERROR;
            throw new IllegalArgumentException(error.message());
        }
    }
}