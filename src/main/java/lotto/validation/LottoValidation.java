package lotto.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoValidation {

    public static final String ERROR_NULL = "[ERROR] 값을 입력해주세요.";

    public static final String ERROR_GAP = "[ERROR] 공백 없이 입력해주세요.";

    public static final String ERROR_ONLY_POSITIVE_INTEGER = "[ERROR] 음수를 제외한 숫자를 입력해주세요.";

    public static final String ERROR_THOUSAND_UNIT = "[ERROR] 1,000원 단위로 입력해주세요.";

    public static final String ERROR_SYMBOL_COMMA_DIVISION = "[ERROR] 로또 번호는 쉼표(,)를 기준으로 구분해주세요.";

    public static final String ERROR_BETWEEN_1_AND_45 = "[ERROR] 로또 번호는 1~45 사이여야 합니다.";

    public static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

    public static final String ERROR_BETWEEN_1_AND_45_BONUS = "[ERROR] 보너스 번호는 1~45 사이여야 합니다.";

    public static final String ERROR_OVERLAP_WINNING_NUMBER = "[ERROR] 당첨 번호와 겹치지 않는 숫자여야 합니다.";

    public void validatePurchaseAmount(String userInput) {
        validateNull(userInput);
        validateGap(userInput);
        validateOnlyPositiveInteger(userInput);
        validateThousandUnit(userInput);
    }

    public void validateWinningNumber(String userInput) {
        validateNull(userInput);
        validateGap(userInput);
        validateCommaDivision(userInput);
        validateOnlyPositiveIntegerList(userInput);
        validateBetween1And45(userInput);
        validateDuplicateNumber(userInput);
    }

    public void validateBonusNumber(String userInput, List<Integer> winningNumber) {
        validateNull(userInput);
        validateGap(userInput);
        validateOnlyPositiveInteger(userInput);
        validateBetween1And45Bonus(userInput);
        validateOverlapWinningNumber(userInput, winningNumber);
    }

    public void validateNull(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException(ERROR_NULL);
        }
    }

    public void validateGap(String userInput) {
        if (userInput.contains(" ")) {
            throw new IllegalArgumentException(ERROR_GAP);
        }
    }

    public void validateOnlyPositiveInteger(String userInput) {
        if (!userInput.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_ONLY_POSITIVE_INTEGER);
        }
    }

    public void validateThousandUnit(String userInput) {
        if (Integer.parseInt(userInput) % 1000 != 0 || Integer.parseInt(userInput) == 0) {
            throw new IllegalArgumentException(ERROR_THOUSAND_UNIT);
        }
    }

    public void validateCommaDivision(String userInput) {
        if (!userInput.contains(",")) {
            throw new IllegalArgumentException(ERROR_SYMBOL_COMMA_DIVISION);
        }
    }

    public void validateOnlyPositiveIntegerList(String userInput) {
        List<String> numbers = Arrays.asList(userInput.split(","));
        for (String number : numbers) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException(ERROR_ONLY_POSITIVE_INTEGER);
            }
        }
    }

    public void validateBetween1And45(String userInput) {
        List<String> numbers = Arrays.asList(userInput.split(","));
        for (String number : numbers) {
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException(ERROR_BETWEEN_1_AND_45);
            }
        }
    }

    public void validateDuplicateNumber(String userInput) {
        List<String> numbers = Arrays.asList(userInput.split(","));
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
    }

    public void validateBetween1And45Bonus(String userInput) {
        if (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 45) {
            throw new IllegalArgumentException(ERROR_BETWEEN_1_AND_45_BONUS);
        }
    }

    public void validateOverlapWinningNumber(String userInput, List<Integer> winningNumber) {
        if (winningNumber.contains(Integer.parseInt(userInput))) {
            throw new IllegalArgumentException(ERROR_OVERLAP_WINNING_NUMBER);
        }
    }
}
