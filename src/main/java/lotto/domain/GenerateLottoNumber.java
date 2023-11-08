package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT = 6;
    private static List<Integer> lottoNumber;
    public static List<Integer> generate() {
        lottoNumber = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT);
        List<Integer> sortedNumbers = new ArrayList<>(lottoNumber);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

}
