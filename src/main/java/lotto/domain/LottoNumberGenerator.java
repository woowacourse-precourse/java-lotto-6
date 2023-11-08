package lotto.domain;

import static lotto.domain.Lotto.MAX_NUMBER_RANGE;
import static lotto.domain.Lotto.MIN_NUMBER_RANGE;
import static lotto.domain.Lotto.NUMBERS_SIZE;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
    public static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE, NUMBERS_SIZE);
    }
}
