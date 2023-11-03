package lotto.domain;

import java.util.List;
import lotto.LottoExceptionMessage;

public class Lotto {
    private static final int REQUIRED_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = create(numbers);
    }

    private void validate(List<Integer> target) {
        validateSize(target);
    }

    private List<LottoNumber> create(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .distinct()
                .toList();
    }

    private void validateSize(List<Integer> target) {
        if (target.size() != REQUIRED_COUNT) {
            throw new IllegalArgumentException(LottoExceptionMessage.NOT_SATISFY_REQUIRED_COUNT.getError());
        }
    }
}
