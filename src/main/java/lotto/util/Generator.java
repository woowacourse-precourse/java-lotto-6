package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.ConfigurationNumbers;

public class Generator {
    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                ConfigurationNumbers.MIN_NUMBER.getNumber(),
                ConfigurationNumbers.MAX_NUMBER.getNumber(),
                ConfigurationNumbers.LOTTO_LENGTH.getNumber()
        );
    }
}
