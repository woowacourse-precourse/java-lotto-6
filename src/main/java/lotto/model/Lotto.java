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
        vaildateLengthOfNumber(numbers);
        validateDuplicatedNumber(numbers);
        vaildateOutOfRangeNumber(numbers);
    }

    private void vaildateLengthOfNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 로또번호를 입력해주세요");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자를 가질 수 없습니다");
        }
    }

    private void vaildateOutOfRangeNumber(List<Integer> numbers) {
      if (numbers.stream()
                .anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)) {
          throw new IllegalArgumentException("[ERROR] 로또 번호는 지정된 범위안의 숫자만 가질 수 있습니다 범위 "
                  + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
      }
    }
}
