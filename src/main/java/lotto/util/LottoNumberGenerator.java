package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public static List<Integer> generateOrderedLottoNumbers() {
        List<Integer> randomNumbers = generateLottoNumbers();
        List<Integer> sortedNumbers = new ArrayList<>(randomNumbers);

        Collections.sort(sortedNumbers);
        return randomNumbers;
    }

    private static List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
