package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class MakeRandomNumbers {
    public static List<Integer> getRandomNumbers(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
