package lotto.util;

import static lotto.constant.Game.MAX_NUMBER;
import static lotto.constant.Game.MIN_NUMBER;
import static lotto.constant.Game.TOTAL_PICK;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNum(), MAX_NUMBER.getNum(), TOTAL_PICK.getNum());
    }
}
