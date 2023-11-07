package lotto.model;

import static lotto.constants.LottoNumber.LOTTO_MIN_NUMBER;
import static lotto.constants.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.constants.LottoNumber.LOTTO_LIST_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGenerator implements RandomNumbersGenerator {

    @Override
    public List<Integer> createUniqueElementList() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_LIST_SIZE);
    }
}