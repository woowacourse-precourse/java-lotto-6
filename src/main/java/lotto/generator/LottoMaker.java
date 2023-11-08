package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMaker {

    public static List<Integer> generateNumber(){

        return orderAscend (Randoms.pickUniqueNumbersInRange(1,45,6));
    }
    private static List<Integer> orderAscend(List<Integer> randomNumbers) {

        return randomNumbers.stream().sorted().collect(Collectors.toList());
    }
}




