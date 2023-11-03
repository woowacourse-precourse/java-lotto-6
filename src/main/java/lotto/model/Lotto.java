package lotto.model;

import static lotto.constant.LottoRuleConstant.LOTTO_MAX_NUM;
import static lotto.constant.LottoRuleConstant.LOTTO_MIN_NUM;
import static lotto.constant.LottoRuleConstant.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        numbers = createAutoLottoNumbers();

        numbers.sort(Comparator.naturalOrder());
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private List<Integer> createAutoLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_SIZE);
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
