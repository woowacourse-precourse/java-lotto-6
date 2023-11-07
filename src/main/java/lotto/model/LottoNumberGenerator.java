package lotto.model;

import static lotto.utils.Constants.LOTTO_NUMBER_COUNT;
import static lotto.utils.Constants.MAX_NUMBER;
import static lotto.utils.Constants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.utils.NumberGenerator;

public class LottoNumberGenerator implements NumberGenerator {

    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }
}