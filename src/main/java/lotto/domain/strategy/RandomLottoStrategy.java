package lotto.domain.strategy;

import static lotto.utils.constants.LottoConstants.LOTTO_NUMBER_LENGTH;
import static lotto.utils.constants.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.utils.constants.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoStrategy implements LottoStrategy {
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_LENGTH);
    }
}
