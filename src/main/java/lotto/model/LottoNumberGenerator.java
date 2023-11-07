package lotto.model;

import java.util.List;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
    public static List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}