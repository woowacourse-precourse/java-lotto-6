package lotto.validation;

import static lotto.constants.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberValidator {

    private static final String DELIMITER = ",";
    private static final String CONSECUTIVE_DELIMITER = DELIMITER + DELIMITER;
    private static final String LOTTO_NUMBERS_PATTERN = "[0-9,]+";

    public List<Integer> validateLottNumbers(String lottoNumbers) {
        validateEmpty(lottoNumbers);
        validateBlank(lottoNumbers);
        validateOnlyNumberAndDelimiter(lottoNumbers);
        validateDelimiterAtBothEnds(lottoNumbers);
        validateConsecutiveDelimiter(lottoNumbers);

        return Arrays.stream(lottoNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer validateBonusNumber(String bonusNumber) {
        validateEmpty(bonusNumber);
        validateBlank(bonusNumber);
        validateNumber(bonusNumber);

        return Integer.valueOf(bonusNumber);
    }

    private void validateEmpty(String lottoNumbers) {
        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NOT_ALLOWED.toString());
        }
    }

    private void validateBlank(String lottoNumbers) {
        if (lottoNumbers.isBlank()) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED.toString());
        }
    }

    private void validateOnlyNumberAndDelimiter(String lottoNumbers) {
        if (!lottoNumbers.matches(LOTTO_NUMBERS_PATTERN)) {
            throw new IllegalArgumentException(String.format(ONLY_NUMBER_OR_DELIMITER_ALLOWED.toString(), DELIMITER));
        }
    }

    private void validateDelimiterAtBothEnds(String lottoNumbers) {
        validateStartWithDelimiter(lottoNumbers);
        validateEndsWithDelimiter(lottoNumbers);
    }

    private void validateStartWithDelimiter(String lottoNumbers) {
        if (lottoNumbers.startsWith(DELIMITER)) {
            throw new IllegalArgumentException(String.format(START_WITH_DELIMITER_NOT_ALLOWED.toString(), DELIMITER));
        }
    }

    private void validateEndsWithDelimiter(String lottoNumbers) {
        if (lottoNumbers.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(String.format(ENDS_WITH_DELIMITER_NOT_ALLOWED.toString(), DELIMITER));
        }
    }

    private void validateConsecutiveDelimiter(String lottoNumbers) {
        if (lottoNumbers.contains(CONSECUTIVE_DELIMITER)) {
            throw new IllegalArgumentException(String.format(CONSECUTIVE_DELIMITER_NOT_ALLOWED.toString(), DELIMITER));
        }
    }

    private void validateNumber(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_ALLOWED.toString());
        }
    }

}
