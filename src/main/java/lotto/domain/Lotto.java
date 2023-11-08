package lotto.domain;

import static lotto.constant.ExceptionMessage.REQUIRE_SIX_NUMBERS;
import static lotto.constant.ExceptionMessage.REQUIRE_UNIQUE_NUMBERS;
import static lotto.constant.Number.LOTTO_MAX_NUM;
import static lotto.constant.Number.LOTTO_MIN_NUM;
import static lotto.constant.Number.LOTTO_NUM_COUNT;

import java.util.Comparator;
import java.util.List;
import lotto.constant.Number;

public class Lotto {

    private final List<Integer> numbers;

    // 자동 숫자 추첨
    public Lotto() {
        this.numbers = issueLotto();
        validate(numbers);
    }

    // 수동
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Integer> issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Number.LOTTO_MIN_NUM.getNumber(),
                Number.LOTTO_MAX_NUM.getNumber(),
                Number.LOTTO_NUM_COUNT.getNumber());
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != Number.LOTTO_NUM_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }
}
