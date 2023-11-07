package lotto.model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
    public static List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }
}