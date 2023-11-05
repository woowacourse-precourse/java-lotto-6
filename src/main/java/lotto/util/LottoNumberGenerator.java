package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {
    }

    public static List<Integer> getRandomNumber(int start, int end, int count) {
        return sortNumbers(Randoms.pickUniqueNumbersInRange(start, end, count));
    }

    private static List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
