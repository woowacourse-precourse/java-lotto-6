package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.ConfigurationNumbers;

public class Generator {
    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                ConfigurationNumbers.MIN_NUMBER.getNumber(),
                ConfigurationNumbers.MAX_NUMBER.getNumber(),
                ConfigurationNumbers.LOTTO_LENGTH.getNumber()
        );
        List<Integer> randomNumbersCopy = new ArrayList<>(randomNumbers);
        return randomNumbersCopy;
    }
}
