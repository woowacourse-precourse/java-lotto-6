package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberGenerator {

    public static List<Integer> getLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortAscend(lottoNumbers);
        return lottoNumbers;
    }

    private static void sortAscend(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Integer::compareTo);
    }


}
