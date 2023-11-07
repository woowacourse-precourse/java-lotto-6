package lotto.util.generator;

import static lotto.model.Lotto.LOTTO_NUMBER_SIZE;
import static lotto.model.Lotto.MAX_LOTTO_NUMBER;
import static lotto.model.Lotto.MIN_LOTTO_NUMBER;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator implements NumberGenerator<List<Integer>> {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
    }
}
