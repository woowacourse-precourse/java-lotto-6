package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberInputValidator implements InputValidator {

    private final static String ENTER_DIFFERENT_6_DIGITS = "로또 번호는 서로다른 6자리로 입력해주세요.";
    private final static String DISCERN_COMMA = ",";
    private final static int LOTTO_LENGTH = 6;
    private final InputValidator numberInputValidator;
    private List<String> inputLottoNumbers;

    public WinningNumberInputValidator(InputValidator numberInputValidator) {
        this.numberInputValidator = numberInputValidator;
    }

    @Override
    public void validate(String input) {
        convertStringNumber(input);
        numberInputValidator();
        validateDuplicateNumber();
        validateLottoNumbersSize();
    }

    private void convertStringNumber(String input) {
        String[] splitLottoNumbers = input.split(DISCERN_COMMA);
        inputLottoNumbers = Arrays.asList(splitLottoNumbers);
    }

    private void numberInputValidator() {
        for (String number : inputLottoNumbers) {
            numberInputValidator.validate(number);
        }
    }

    private void validateDuplicateNumber() {
        Set<String> validateDuplicateNumber = new HashSet<>(inputLottoNumbers);
        if (validateDuplicateNumber.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ENTER_DIFFERENT_6_DIGITS);
        }
    }

    private void validateLottoNumbersSize() {
        if (inputLottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(ENTER_DIFFERENT_6_DIGITS);
        }
    }

}
