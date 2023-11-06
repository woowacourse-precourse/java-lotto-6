package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
                validate(numbers);
                validateDuplicateNumber(numbers);
                this.numbers = numbers;
        }

        private void validate(List<Integer> numbers) {
                if (numbers.size() != 6) {
                        throw new IllegalArgumentException("로또는 6가지의 서로 다른 수여야 합니다.");
                }
        }

        private void validateDuplicateNumber(List<Integer> numbers) {
                Set<Integer> numberSet = new HashSet<>(numbers);
                if (numberSet.size() != 6) {
                        throw new IllegalArgumentException("로또는 중복된 숫자를 포함할 수 없습니다.");
                }
        }

        public boolean hasNumber(int number) {
                return numbers.contains(number);
        }

        public long matchCount(Lotto target) {
                return numbers.stream().filter(target::hasNumber).count();
        }
}
