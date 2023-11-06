package lotto.service.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<Integer> LottoNumberGenerator() {
        return NumberAscendingSort();
    }

    private static List<Integer> NumberAscendingSort() {
        List<Integer> numbers = RandomNumberGenerator();
        List<Integer> number = new ArrayList<>(numbers);
        Collections.sort(number);
        return number;
    }

    private static List<Integer> RandomNumberGenerator() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
