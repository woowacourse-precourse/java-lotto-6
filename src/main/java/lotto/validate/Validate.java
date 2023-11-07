package lotto.validate;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validate {

    private static final String THOUSAND_UNIT_ERROR = "[ERROR] 1000단위의 숫자로 입력 해주세요.";
    private static final String FORMAT_ERROR = "[ERROR] 입력 값은 숫자와 콤마만 포함해야 하며 공백을 포함할 수 없습니다.";
    private static final String MINIMUM_AMOUNT_ERROR = "[ERROR] 1000이상의 숫자로 입력 해주세요.";
    private static final String RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String SIX_NUMBERS_ERROR = "[ERROR] 중복없는 6개의 숫자로 입력 해주세요.";
    private static final String DIGIT_ERROR = "[ERROR] 숫자만 입력 해주세요.";
    private static final String BONUS_NUMBER_ERROR = "[ERROR] 보너스번호가 당첨번호랑 중복됩니다.";

    public static void checkThousandMultiple(int inputData) {
        if (inputData % 1000 != 0) {
            throw new IllegalArgumentException(THOUSAND_UNIT_ERROR);
        }
    }

    public static void checkFormat(String inputData) {
        if (!inputData.matches("^\\d+(?:,\\d+)*$")) {
            throw new IllegalArgumentException(FORMAT_ERROR);
        }
    }

    public static void checkMinimumAmount(int inputData) {
        if (inputData < 1000) {
            throw new IllegalArgumentException(MINIMUM_AMOUNT_ERROR);
        }
    }

    public static void checkNumberInRange(String inputData) {
        List<Integer> numbers = Arrays.stream(inputData.split(","))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());
        numbers.forEach(Validate::checkSingleNumberInRange);
    }

    public static void checkSingleNumberInRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    public static void checkValidSixNumberInput(String inputData) {
        Set<Integer> numbers = Arrays.stream(inputData.split(","))
                                     .map(Integer::parseInt)
                                     .collect(Collectors.toSet());
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIX_NUMBERS_ERROR);
        }
    }

    public static void checkNumericInput(String inputData) {
        if (!inputData.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(DIGIT_ERROR);
        }
    }

    public static void checkBonusNumberUniqueness(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR);
        }
    }
}
