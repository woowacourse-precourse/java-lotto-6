package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Committee {
    private static Committee committee = new Committee();

    private Committee() {

    }

    public static Committee getInstance() {
        return committee;
    }

    public List<Integer> setWinningNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
