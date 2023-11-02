package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
