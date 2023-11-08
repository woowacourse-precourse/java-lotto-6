package lotto.domain;

import static lotto.domain.constants.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.domain.constants.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.domain.constants.LottoConstants.LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .toList();
    }
}
