package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constant.NumericConstant.LOTTO_SIZE;
import static lotto.constant.NumericConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.NumericConstant.MIN_LOTTO_NUMBER;

public class DefualtLottoNumbersGenerator implements LottoNumbersGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
    }
}
