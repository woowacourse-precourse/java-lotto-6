package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_LENGTH;
import static lotto.constants.LottoConstants.MAXIMUM_NUM;
import static lotto.constants.LottoConstants.MINIMUM_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = makeSixSortedLottoNum();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> makeSixSortedLottoNum() {
        List<Integer> sixLottoNum = Randoms.pickUniqueNumbersInRange(MINIMUM_NUM, MAXIMUM_NUM, LOTTO_LENGTH);
        Collections.sort(sixLottoNum);
        return sixLottoNum;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
