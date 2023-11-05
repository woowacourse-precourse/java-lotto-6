package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.Number;

public class Lotto {

    private List<Integer> numbers;

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
        numbers = Randoms.pickUniqueNumbersInRange(Number.LOTTO_MIN_NUM, Number.LOTTO_MAX_NUM, Number.LOTTO_NUM_COUNT);
        return numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != Number.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
