package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSizeIs6(numbers);
        validateDuplicateNumbers(numbers);
        validateRangeNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSizeIs6(List<Integer> numbers) {
        if (IsSizeSix(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개만 가능합니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (hasDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력될 수 없습니다.");
        }
    }

    private void validateRangeNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 잘못된 숫자 범위는 입력될 수 없습니다."));
    }

    private static boolean IsSizeSix(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private static boolean hasDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
}
