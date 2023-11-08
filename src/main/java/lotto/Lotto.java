package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 1개의 로또를 발행할 때 6개의 숫자를 전달해야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
