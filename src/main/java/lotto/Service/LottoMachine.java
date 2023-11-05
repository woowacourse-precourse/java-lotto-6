package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;


public class LottoMachine {
    public static Integer lottoCount(Integer price) {
        return price / 1000;
    }
    public static List<Integer> makeRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
