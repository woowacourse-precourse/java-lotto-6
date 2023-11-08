package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Generator {
    public static List<Integer> generateNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return numbers;
    }
}
