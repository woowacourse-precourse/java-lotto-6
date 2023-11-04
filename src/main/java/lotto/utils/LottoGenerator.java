package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Rule.*;

public class LottoGenerator {
    private static List<Integer> lottoNumbers;
    private static ArrayList<Integer> sortedLottoNumbers;

    public LottoGenerator() {
    }

    public static List<Integer> generateLotto() {
        generateNumbersInRange();
        sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        sortLotto();
        return sortedLottoNumbers;
    }

    private static void generateNumbersInRange() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO.getValue(), MAX_LOTTO.getValue(), LOTTO_SIZE.getValue());
    }

    private static void sortLotto() {
        Collections.sort(sortedLottoNumbers);
    }
}
