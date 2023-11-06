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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_6_REQUIRED);
        }

        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_NOT_ALLOWED);
        }
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        long removeDuplicatedSize = numbers.stream().distinct().count();
        if (numbers.size() != removeDuplicatedSize) {
            return true;
        }

        return false;
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
