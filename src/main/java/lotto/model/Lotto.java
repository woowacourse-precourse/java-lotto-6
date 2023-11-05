package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.Constant;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = generateLotto();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    // Lotto 생성
    private List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constant.LOTTO_NUMBER_MIN,
                Constant.LOTTO_NUMBER_MAX, Constant.LOTTO_NUMBER_COUNT);
        return numbers;
    }
}
