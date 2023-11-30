package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.grobal.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.grobal.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.grobal.LottoConstants.LOTTO_NUMBER_SIZE;

public class RandomLottoGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
    }
}
