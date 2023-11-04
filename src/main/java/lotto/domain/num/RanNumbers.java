package lotto.domain.num;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RanNumbers {
    private static final Integer startInclusive = 1;
    private static final Integer endInclusive = 45;
    private static final Integer countOfNumber = 6;
    private List<Integer> randomNumbers;

    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, countOfNumber);
    }

}
