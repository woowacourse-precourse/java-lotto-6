package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class RandomNumbers extends LottoNumber {

    public RandomNumbers() {
    }

    public static List<Integer> generateRandomNumbers() {
        return pickUniqueNumbersInRange(NUMBER_MIN_SIZE,NUMBER_MAX_SIZE,LOTTO_SIZE);
    }
}
