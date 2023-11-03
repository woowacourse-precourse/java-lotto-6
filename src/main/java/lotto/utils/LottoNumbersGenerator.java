package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGenerator {
    public static List<Integer> generate() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }
}
