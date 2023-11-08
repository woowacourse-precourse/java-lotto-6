package lotto.model;

import static lotto.constants.LottoNumber.LOTTO_MIN_NUMBER;
import static lotto.constants.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.constants.LottoNumber.LOTTO_LIST_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Supplier;

public class LottoNumbersGenerator implements Supplier<List<Integer>> {

    @Override
    public List<Integer> get() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_LIST_SIZE);
    }
}