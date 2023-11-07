package lotto.core;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.constValue.ConstNumber.*;

public class Random {
    public static List<Integer> getRandomNumbers(){
        List<Integer> randomNumbers =
                Randoms.pickUniqueNumbersInRange(
                        MIX_LOTTO_NUMBER,MAX_LOTTO_NUMBER,
                        LOTTO_NUMBER_LENGTH
                );

        List<Integer> sortedRandomNumbers = new ArrayList<>(randomNumbers);
        sortedRandomNumbers.sort(null);
        return sortedRandomNumbers;
    }
}
