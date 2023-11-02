package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.io.Constants;

import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator {

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.
                pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUM, Constants.LOTTO_MAX_NUM, Constants.LOTTO_NUMBERS);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}
