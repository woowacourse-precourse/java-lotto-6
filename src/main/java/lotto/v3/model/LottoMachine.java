package lotto.v3.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.v3.util.LottoConstants;

import java.util.List;

public class LottoMachine {
    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_NUMBER_MIN.getValue(),
                LottoConstants.LOTTO_NUMBER_MAX.getValue(),
                LottoConstants.LOTTO_NUMBERS_SIZE.getValue()
        );
        return new Lotto(numbers);
    }

}