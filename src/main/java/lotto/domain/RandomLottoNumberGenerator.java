package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.Constants;

import java.util.List;

public class RandomLottoNumberGenerator {

    public List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUM, Constants.LOTTO_MAX_NUM, Constants.LOTTO_NUMBERS);
    }

}
