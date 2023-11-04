package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class AutomaticLottoNumbers {

    public static List<Integer> create() {
        List<Integer> winLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(winLottoNumbers);
        return winLottoNumbers;
    }
}
