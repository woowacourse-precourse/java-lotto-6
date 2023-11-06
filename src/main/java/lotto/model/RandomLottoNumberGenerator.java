package lotto.model;

import static lotto.constant.LottoInfo.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoInfo.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoInfo.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> pickNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getValue(),
                LOTTO_MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());

        return numbers;
    }
}
