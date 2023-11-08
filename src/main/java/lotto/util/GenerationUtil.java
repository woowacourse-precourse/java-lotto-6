package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.enums.ConstVariable;

public class GenerationUtil {

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                ConstVariable.MIN_NUMBER.getValue(),
                ConstVariable.MAX_NUMBER.getValue(),
                ConstVariable.LOTTO_COUNT.getValue()
        );
    }
}
