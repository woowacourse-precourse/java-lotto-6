package lotto.domain;

import static lotto.utils.constants.LottoConstants.LOTTO_END_NUMBER;
import static lotto.utils.constants.LottoConstants.LOTTO_NUMBERS;
import static lotto.utils.constants.LottoConstants.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGenerator {

    public List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBERS);
    }

}
