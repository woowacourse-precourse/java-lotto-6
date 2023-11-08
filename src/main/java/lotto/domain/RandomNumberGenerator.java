package lotto.domain;

import static lotto.constants.Constants.MIN_NUMBER;
import static lotto.constants.Constants.MAX_NUMBER;
import static lotto.constants.Constants.LOTTO_COUNT;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {

    static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT);
    }
}
