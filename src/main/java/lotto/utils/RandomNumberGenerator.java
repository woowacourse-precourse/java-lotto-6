package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constants.LottoConstants.*;

public class RandomNumberGenerator {

    public List<Integer> uniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
    }
}
