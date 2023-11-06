package lotto.domain.num;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RanNumbers {
    // TODO: 11/6/23 상수 관리
    private static final Integer START_INCLUSIVE = 1;
    private static final Integer END_INCLUSIVE = 45;
    private static final Integer TOTAL_COUNT_NUMBER = 6;

    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, TOTAL_COUNT_NUMBER);
    }

}
