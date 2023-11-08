package lotto.domain.event.input;

import java.util.List;
import lotto.exception.LottoValidateException;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoValidateException("6개의 번호여야 합니다.");
        }
    }

}
