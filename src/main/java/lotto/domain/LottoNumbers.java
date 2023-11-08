package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final int CNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    //private static List<Integer> randomLottoNumbers = new ArrayList<>();

    public static List<Integer> setRandomLottoNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                CNT_LOTTO_NUMBER);
        //Collections.sort(randomNumbers);
        //randomNumbers.sort(Comparator.naturalOrder());
        return randomNumbers;
    }
}
