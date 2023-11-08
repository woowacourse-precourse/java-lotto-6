package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNoDuplicateNumbers(numbers);
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호가 6개가 아닌 %d개입니다.".formatted(numbers.size()));
        }
    }

    // TODO: 추가 기능 구현
    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호에 중복된 숫자(%d)가 존재합니다.".formatted(number));
            }
            uniqueNumbers.add(number);
        }
    }

    private void validateLottoNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || 45 < number) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}
