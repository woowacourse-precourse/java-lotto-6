package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class MakeRandomNumbers {
    public static List<Integer> getRandomNumbers(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        randomNumbers.sort(Comparator.naturalOrder());
        return randomNumbers;
    }
}
