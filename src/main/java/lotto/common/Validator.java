package lotto.common;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Class : 유효성 검사 공통 클래스
 */
public class Validator {

    public static boolean isMultipleOfNumber(int value, int unit) {
        return value % unit == 0;
    }

    public static boolean isDuplicateValue(List<Integer> targetList) {
        List<Integer> distinctList = targetList.stream().distinct().collect(Collectors.toList());
        return targetList.size() != distinctList.size();
    }

    public static boolean isBetweenValue(List<Integer> targetList, int min, int max) {
        return targetList.stream()
                .allMatch(number -> isBetween(number, min, max));
    }

    public static boolean isListSizeEquals(List<Integer> targetList, int size) {
        return targetList.size() == size;
    }

    public static boolean isBetween(int number, int min, int max) {
        return number >= min && number <= max;
    }

    public static boolean isContainNumber(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}
