package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        validate(numbers);
        validateDistinct(numbers);
        this.numbers = numbers;
    }

    private void validateDistinct(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validate(List<Integer> numbers) {
       numbers.forEach(number -> {
                     if (number < 1 || number > 45) {
                          throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
                     }
                });
    }

    public int matchNumbers(LottoNumber target) {
        return (int) this.numbers.stream()
                .filter(target::contains)
                .count();
    }

    public boolean containsBonusNumber(int targetBonusNumber) {
        return numbers.contains(targetBonusNumber);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private boolean contains(Integer integer) {
        return numbers.contains(integer);
    }
}
