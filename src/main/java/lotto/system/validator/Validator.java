package lotto.system.validator;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern ARABIC_NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final int MINIMUM_UNIT = 1000;
    private static final int ZERO = 0;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private enum ExceptionMessage {
        EMPTY_VALUE_NOT_ALLOWED("[ERROR] 빈 값을 입력할 수 없습니다."),
        INVALID_ARABIC_NUMBER("[ERROR] 아라비아 숫자만 입력할 수 있습니다."),
        NOT_DIVISIBLE_BY_1000("[ERROR] 1,000원 단위로만 입력할 수 있습니다."),
        NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        DUPLICATED_BONUS_NUMBER("[ERROR] 당첨 번호와 중복되는 숫자는 입력할 수 없습니다.");
        private final String message;

        ExceptionMessage(String message) {
            this.message = message;
        }
    }

    public void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_VALUE_NOT_ALLOWED.message);
        }
    }

    public void validateArabicNumber(String input) {
        if (!ARABIC_NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ARABIC_NUMBER.message);
        }
    }

    public void validateDivisibleBy1000(String input) {
        if (Integer.parseInt(input) % MINIMUM_UNIT != ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_BY_1000.message);
        }
    }

    public void validateNumberInRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_LOTTO_NUMBER && number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Validator.ExceptionMessage.NUMBER_OUT_OF_RANGE.message);
        }
    }

    public void validateBonusNumberInWinningNumber(List<Integer> winningNumbers, String input) {
        int bonusNumber = Integer.parseInt(input);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_BONUS_NUMBER.message);
        }
    }

    public void validateNotEmptyAndArabicNumber(String input) {
        validateNotEmpty(input);
        validateArabicNumber(input);
    }

    public void validatePurchaseAmount(String input) {
        validateNotEmptyAndArabicNumber(input);
        validateDivisibleBy1000(input);
    }

    public void validateWinningNumbers(List<String> userInputNumbers) {
        userInputNumbers.forEach(
                number -> {
                    validateNotEmptyAndArabicNumber(number);
                    validateNumberInRange(number);
                }
        );
    }

    public void validateBonusNumber(String input) {
        validateNotEmptyAndArabicNumber(input);
        validateNumberInRange(input);
    }
}
