package lotto.domain.validator;

import java.util.List;

import lotto.util.constants.ValidateConstants;


public class WinnerNumberValidator implements Validator<List<String>> {
    @Override
    public void validate(List<String> inputWinnerNumber) {
        validateNumeric(inputWinnerNumber);
    }


    public void validateNumeric(List<String> winnerNumbers) {
        boolean invalidNumeric = winnerNumbers.stream()
                .anyMatch(string -> !string.matches(ValidateConstants.NUMERIC_REGEX.getConstants()));
        if (invalidNumeric) {
            throw new IllegalArgumentException(ValidateConstants.LOTTO_NUMBER_NUMERIC_ERROR.getConstants());
        }
    }
}
