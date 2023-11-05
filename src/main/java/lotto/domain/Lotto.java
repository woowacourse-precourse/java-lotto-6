package lotto.domain;

import java.util.List;
import lotto.system.ExceptionMessage;
import lotto.system.LottoNumberConstant;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (LottoNumberConstant.LENGTH.isNotEqual(numbers.size())) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_LENGTH.getMessage());
        }
    }

    // TODO: 추가 기능 구현
}
