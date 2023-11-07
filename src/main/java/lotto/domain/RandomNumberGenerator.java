package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {

    static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER, Constants.LOTTO_COUNT);
    }
}
