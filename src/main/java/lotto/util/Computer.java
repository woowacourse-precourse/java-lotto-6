package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.enums.LottoNumberRange;

public class Computer {
    public List<Integer> getRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumberRange.MIN_NUMBER.getValue(),
                LottoNumberRange.MAX_NUMBER.getValue(), LottoNumberRange.MIN_SELECT_COUNT.getValue());
        return numbers;
    }
}
