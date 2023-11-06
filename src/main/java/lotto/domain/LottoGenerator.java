package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static Lotto generatorLotto() {
        List<Integer> randomNumbers = generateRandomNumbers();
        sortByAsc(randomNumbers);
        return new Lotto(randomNumbers);
    }

    private static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static void sortByAsc(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers);
    }
}
