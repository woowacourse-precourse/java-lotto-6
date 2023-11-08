package lotto.model;

import java.util.List;

public class Lotto {
    public static class Lotto {
        private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
            validate(numbers);
            this.numbers = numbers;
        }

        private void validate(List<Integer> numbers) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 입력 가능합니다.");
            }
        }

        // TODO: 추가 기능 구현
    }
}
