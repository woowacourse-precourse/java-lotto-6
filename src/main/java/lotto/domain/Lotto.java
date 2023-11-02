package lotto.domain;

import java.util.List;
import lotto.domain.LottoStatus;

public class Lotto {

    public static final Integer MIN = 0;
    public static final Integer MAX = 45;

    private final List<Integer> numbers;
    private LottoStatus status;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
