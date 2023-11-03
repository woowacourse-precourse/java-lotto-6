package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class AutomaticLottoNumbers {

    public static List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
