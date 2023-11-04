package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidator {

    public static void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    public static void validateNumberSize(List<Integer> numbers) {
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean hasDuplicate = numbers.stream()
                .anyMatch(number -> !uniqueNumbers.add(number));
        if (hasDuplicate) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함되었습니다.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        boolean isRangeValid = numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45);
        if (!isRangeValid) {
            throw new IllegalArgumentException("[ERROR] 로또 범위는 1 ~ 45 입니다.");
        }
    }

}
