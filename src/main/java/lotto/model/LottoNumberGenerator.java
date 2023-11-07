package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.utils.Constants;
import lotto.utils.NumberGenerator;

public class LottoNumberGenerator implements NumberGenerator {

    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_NUMBER.getNumber(), Constants.MAX_NUMBER.getNumber(),
                Constants.LOTTO_NUMBER_COUNT.getNumber());
    }
}