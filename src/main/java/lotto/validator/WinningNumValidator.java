package lotto.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class WinningNumValidator {
    private static final String TYPE_ERROR = "[ERROR] 로또 번호는 정수이어야 합니다.";
    private static final String LANGTH_ERROR = "[ERROR] 로또 번호는 6자리여야 합니다.";
    private static final String DUPLICATION_ERROR = "[ERROR] 중복된 수가 포함되어 있습니다.";
    private static final String RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static List<Integer> validate(String[] winningNum) {
        List<Integer> result = validateType(winningNum);
        result.forEach((number) -> {
            validateRange(number);
        });
        validateLangth(result);
        return validateDuplication(result);
    }

    private static List<Integer> validateType(String[] numbers) {
        List<Integer> result = new ArrayList<Integer>();
        try {
            for (String number : numbers) {
                result.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
        return result;
    }

    private static void validateLangth(List<Integer> winningNum) {
        if (winningNum.size() != 6) {
            throw new IllegalArgumentException(LANGTH_ERROR);
        }
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private static List<Integer> validateDuplication(List<Integer> winningNum) {
        Set<Integer> numSet = new HashSet<Integer>(winningNum);
        if (winningNum.size() != numSet.size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR);
        }
        return winningNum;
    }
}
