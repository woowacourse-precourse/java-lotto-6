package lotto.domain;

import static lotto.constant.LottoConstants.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoConstants.LOTTO_SIZE;

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
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
    }

    private static void sortByAsc(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers);
    }
}
