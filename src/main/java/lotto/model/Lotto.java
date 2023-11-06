package lotto.model;

import java.util.List;

public class Lotto {
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (validateDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자를 가질 수 없습니다");
        }
        if (vaildateOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 지정된 범위안의 숫자만 가질 수 있습니다 범위 "
                    + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
        }
    }
    private boolean validateDuplicatedNumber(List<Integer> numbers) {
        return (numbers.stream()
                .distinct()
                .count() < numbers.size());
    }

    private boolean vaildateOutOfRangeNumber(List<Integer> numbers) {
      return (numbers.stream()
                .anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER));
    }
}
