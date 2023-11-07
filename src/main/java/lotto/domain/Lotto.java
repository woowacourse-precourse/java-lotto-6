package lotto.domain;

import java.util.List;

public class Lotto {
    private static final String LOTTO_NUMBER_SIZE_6_REQUIRED = "로또 번호는 6개여야합니다";
    private static final String LOTTO_NUMBER_DUPLICATE_NOT_ALLOWED = "로또 번호는 중복되면 안됩니다";
    private static final String DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_6_REQUIRED);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        long removeDuplicatedSize = numbers.stream().distinct().count();
        if (numbers.size() != removeDuplicatedSize) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_NOT_ALLOWED);
        }
    }

    public String getNumbers() {
        return String.join(DELIMITER, numbers.stream().map(number -> number.toString()).toList());
    }

    public int numberMatch(List<Integer> matchNumbers) {
        int count = 0;

        for (Integer matchNumber : matchNumbers) {
            if (isMatch(matchNumber)) {
                count++;
            }
        }

        return count;
    }

    public boolean isMatch(int number) {
        return numbers.contains(number);
    }
}
