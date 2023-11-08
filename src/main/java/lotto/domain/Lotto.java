package lotto.domain;

import java.util.List;
import lotto.domain.util.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 6개 선택해야 합니다.");
        }
        if (!numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("로또 숫자는 1~45까지의 정수만 선택해야 합니다.");
        }
        Validation.validateLottoNumbers(numbers);
    }

    // TODO: 추가 기능 구현
}
