package lotto.domain;

import java.util.List;
import lotto.congin.LottoConfing;
import lotto.excption.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfing.LoTTO_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_LENGTH);
        }
    }

    // TODO: 추가 기능 구현

    public Long countCommon(List<Integer> numbers) {
        return this.numbers.stream()
                .filter(numbers::contains)
                .count();
    }
}
