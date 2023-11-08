package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

        public Lotto(List<Integer> numbers) {
            validate(numbers);
            this.numbers = numbers;
        }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이어야 합니다.");
            }
            for (int j = i + 1; j < numbers.size(); j++) {
                if (number.equals(numbers.get(j))) {
                    throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
                }
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
