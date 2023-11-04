package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoInputValidator implements InputValidator {

    private final static String DELIMITER = ",";
    private final static int NUMBERS_LENGTH = 6;

    private final NumberInputValidator numberInputValidator = new NumberInputValidator();
    private List<String> inputStrings;

    @Override
    public void validate(String input) {
        setInputStrings(input);
        throwIfContainsInvalidNumber();
        throwIfContainsDuplicateNumber();
        throwIfLengthIsNotSix();
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
            throw new IllegalArgumentException();
        }
    }

    private void throwIfContainsDuplicateNumber() {
        Set<String> duplicateChecker = new HashSet<>(inputStrings);
        if (duplicateChecker.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
