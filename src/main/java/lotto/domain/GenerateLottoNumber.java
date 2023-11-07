package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumber {
    private static List<Integer> lottoNumber;
    public static List<Integer> generate() {
        lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = new ArrayList<>(lottoNumber);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

}
