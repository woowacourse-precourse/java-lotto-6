package lotto.util;

import static lotto.util.ConstantUtils.LOTTO_SIZE_CRITERION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationUtils {

    public static void validateNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해야 합니다.");
        }
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException("로또는 숫자 여섯 개로 이루어져야 합니다.");
        }
    }

    public static void validateNoDuplicatedNumberInList(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException("로또에 중복 되는 숫자가 있습니다.");
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers, int startInclusive,
        int endInclusive) {

        for (int number : numbers) {
            validateNumberInRange(number, startInclusive, endInclusive);
        }
    }

    public static void validateNumberInRange(int number, int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("시작 범위가 종료 범위보다 클 수 없습니다.");
        }
        if (number < startInclusive || number > endInclusive) {
            throw new IllegalArgumentException(
                "숫자 " + number + "가 허용된 범위(" + startInclusive + " ~ " + endInclusive
                    + ")를 벗어났습니다.");
        }
    }
}
