package lotto.domain;

import static lotto.domain.constant.LottoNumberConstant.LOTTO_SIZE;
import static lotto.domain.exception.DomainExceptionCode.LOTTO_MUST_NOT_BE_DUPLICATE;
import static lotto.domain.exception.DomainExceptionCode.LOTTO_SIZE_MUST_BE_SAME;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LOTTO_SIZE_MUST_BE_SAME.dynamicInvokeBy(() -> LOTTO_SIZE.isNotEqualTo(numbers.size()));
        LOTTO_MUST_NOT_BE_DUPLICATE.dynamicInvokeBy(() -> LOTTO_SIZE.isNotEqualTo(new HashSet<>(numbers).size()));
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public boolean contains(int value) {
        return numbers.contains(value);
    }

    public int matchCount(Lotto otherLotto) {
        final var lottoSet = new HashSet<>(this.numbers);
        lottoSet.addAll(otherLotto.numbers);

        return 12 - lottoSet.size();
    }
}
