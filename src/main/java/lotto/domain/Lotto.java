package lotto.domain;

import static lotto.domain.constant.LottoNumberConstant.LOTTO_SIZE;
import static lotto.domain.exception.DomainExceptionCode.LOTTO_MUST_NOT_BE_DUPLICATE;
import static lotto.domain.exception.DomainExceptionCode.LOTTO_SIZE_MUST_BE_SAME;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int COMBINE_MAX_SIZE = 12;
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

    /**
     * <p>로또 번호 6개 다른 로또 번호 6개를 합치면 12개가 나옵니다.
     * 즉 중복되지 않는 경우라면 12개가 나오기 때문에 일치하는 숫자는 0개이며 모두 일치하면 6개가 나오게 됩니다.
     * </p>
     *
     * @param otherLotto
     * @return
     */
    public int matchCount(Lotto otherLotto) {
        final var combineLotto = new HashSet<>(this.numbers);
        combineLotto.addAll(otherLotto.numbers);

        return COMBINE_MAX_SIZE - combineLotto.size();
    }

}
