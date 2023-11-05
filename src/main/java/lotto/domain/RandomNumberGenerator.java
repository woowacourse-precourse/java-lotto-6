package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator{

    public static List<Integer> createUniqueRandomNumbers(){
        return sortRandomNumbers(pickUniqueNumbersInRange(1,45,6));
    }

    private static List<Integer> sortRandomNumbers(List<Integer> randomNumbers){
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

}
