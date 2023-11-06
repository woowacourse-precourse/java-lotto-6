package lotto.domain.num;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RanNumbers {
    // TODO: 11/6/23 상수 관리
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 45;
    private static final Integer COUNT_TOTAL_NUMBER = 6;

    public static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_TOTAL_NUMBER);
    }

}
