package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private final static int START_RANGE = 1;
    private final static int END_RANGE = 45;
    private final static int LOTTO_SIZE = 6;
    private final static String NOT_CORRECT_SIZE_MSG = "[ERROR] 로또는 6개의 숫자로 이루어져야 합니다.";
    private final static String DUPLICATE_MSG = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private final static String WRONG_FORMAT_MSG = "[ERROR] 1 ~ 45 사이의 숫자만 입력 가능합니다.";

    public static void check(List<Integer> lotto) {
        checkSize(lotto);
        checkNumberRange(lotto);
        checkUnique(lotto);
    }

    private static void checkSize(List<Integer> lotto) throws IllegalArgumentException {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NOT_CORRECT_SIZE_MSG);
        }
    }

    private static void checkNumberRange(List<Integer> lotto) throws IllegalArgumentException {
        for (Integer number : lotto) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(WRONG_FORMAT_MSG);
            }
        }
    }

    private static void checkUnique(List<Integer> lotto) throws IllegalArgumentException {
        if (isDuplicated(lotto)) {
            throw new IllegalArgumentException(DUPLICATE_MSG);
        }
    }

    private static boolean isOutOfRange(int number) {
        return (number < START_RANGE || number > END_RANGE);
    }

    private static boolean isDuplicated(List<Integer> lotto) {
        Set<Integer> uniqueNumbers = new HashSet<>(lotto);
        return uniqueNumbers.size() != lotto.size();
    }
}
