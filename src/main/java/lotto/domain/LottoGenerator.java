package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static List<Integer> getLottoNumbers() {
        List<Integer> numbers = pickLottoNumbers();
        Collections.sort(numbers);
        return numbers;
    }
    private static List<Integer> pickLottoNumbers() {
        List<Integer> numbers = pickNumber();
        return numbers;
    }
    private static List<Integer> pickNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
