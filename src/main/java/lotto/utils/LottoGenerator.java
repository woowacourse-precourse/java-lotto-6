package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.constants.Rule.*;

public class LottoGenerator {
    private static List<Integer> lottoNumbers;

    public LottoGenerator() {
    }

    public static List<Integer> generateLotto() {
        generateNumbersInRange();
        sortLotto();
        return lottoNumbers;
    }

    private static void generateNumbersInRange() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO.getValue(), MAX_LOTTO.getValue(), LOTTO_SIZE.getValue());
    }

    private static void sortLotto() {
        Collections.sort(lottoNumbers);
    }
}
