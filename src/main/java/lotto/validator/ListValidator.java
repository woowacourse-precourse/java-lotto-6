package lotto.validator;

import java.util.List;

public class ListValidator {
    private ListValidator() {
    }

    public static void validateNotEmpty(List<Integer> list) {
        final String message = "로또 번호는 비어있으면 안됩니다.";
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        final String message = "당첨 번호의 개수는 %d개여야 합니다.";
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException(String.format(message));
        }
    }

    public static void validateUniqueNumbers(List<Integer> numbers) {
        final String message = "로또 번호에 중복된 숫자가 있으면 안됩니다.";
        final long distinctCount = numbers.stream().distinct().count();
        if (numbers.size() != distinctCount) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotContains(List<Integer> numbers, int bonusNumber) {
        final String message = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
        validateNotEmpty(numbers);
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(message);
        }
    }
}
