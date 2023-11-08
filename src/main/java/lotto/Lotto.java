package lotto;

import java.util.List;

public class Lotto {

        private final List<Integer> numbers;
        private final Integer LOTTO_NUM_SIZE = 6;

        public Lotto(List<Integer> numbers) {
                validate(numbers);
                this.numbers = numbers;
        }

        public void validate(List<Integer> numbers) {
                validateSize(numbers);
                validateNumbersInRange(numbers);
                validateSameNumber(numbers);
        }

        private void validateSize(List<Integer> numbers) {
                if (numbers.size() != 6) {
                        throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해야 합니다.");
                }
        }

        private void validateNumbersInRange(List<Integer> numbers) {
                for (Integer number : numbers) {
                        if (number < 1 || number > 45) {
                                throw new IllegalArgumentException(
                                        "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                        }
                }
        }

        public void validateSameNumber(List<Integer> numbers) {
                if (numbers.stream().distinct().count() != LOTTO_NUM_SIZE) {
                        throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
                }
        }


        public List<Integer> getNumbers() {
                return numbers;
        }

        // TODO: 추가 기능 구현
}