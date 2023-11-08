package lotto.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("정수가 아닙니다.");
        }
    }

    public static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양의 숫자가 아닙니다.");
        }
    }

    // 입력 값이 나누어 떨어지는지 검증
    public static void validateDivideNumber(int number, int divide) {
        if (number % divide != 0) {
            throw new IllegalArgumentException(divide + " 값으로 나누어 떨어지지 않습니다.");
        }
    }

    // 입력 값이 해당 범위에 있는지 검증
    public static void validateNumberInRange(int number, int start, int end) {
        if (number < start || number > end) {
            throw new IllegalArgumentException("입력 값이 해당 범위에 없습니다.");
        }
    }

    // 입력 값이 List에 있는 값과 중복되는지 검증
    public static void validateDuplicatedInList(int number, List<Integer> compares) {
        if (compares.contains(number)) {
            throw new IllegalArgumentException("입력 값이 중복되어 존재합니다.");
        }
    }

    // int 자료형 List에 중복이 있는지 검증
    public static void validateDuplicatedOfList(List<Integer> compares) {
        Set<Integer> removeDuplicatedNumbers = new HashSet<>(compares);

        if (compares.size() != removeDuplicatedNumbers.size()) {
            throw new IllegalArgumentException("List에 중복이 존재합니다.");
        }
    }
}
