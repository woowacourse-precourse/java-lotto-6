package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoInputValidator implements InputValidator {

    private final static String ERROR_CONTAINS_DUPLICATE_NUMBER = "중복된 숫자가 포함되어 있습니다.";
    private final static String ERROR_LENGTH_IS_NOT_SIX = "번호의 길이는 6이어야 합니다.";

    private final static String DELIMITER = ",";
    private final static int NUMBERS_LENGTH = 6;

    private final NumberInputValidator numberInputValidator = new NumberInputValidator();
    private List<String> inputStrings;

    @Override
    public void validate(String input) {
        setInputStrings(input);
        throwIfContainsInvalidNumber();
        throwIfLengthIsNotSix();
        throwIfContainsDuplicateNumber();
    }

    private void setInputStrings(String input) {
        inputStrings = Arrays
                .stream(input.split(DELIMITER))
                .toList();
    }

    private void throwIfContainsInvalidNumber() {
        inputStrings.forEach(numberInputValidator::validate);
    }

    private void throwIfLengthIsNotSix() {
        if (inputStrings.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH_IS_NOT_SIX);
        }
    }

    private void throwIfContainsDuplicateNumber() {
        Set<String> duplicateChecker = new HashSet<>(inputStrings);
        if (duplicateChecker.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR_CONTAINS_DUPLICATE_NUMBER);
        }
    }
}
