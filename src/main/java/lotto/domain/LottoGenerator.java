package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public List<Integer> generateSixNumbers() {
        List<Integer> sixNumbers = Randoms.pickUniqueNumbersInRange(LottoNumbers.MIN_LOTTO_NUMBER.getNumber(),
                LottoNumbers.MAX_LOTTO_NUMBER.getNumber(), 6);
        Collections.sort(sixNumbers);
        return sixNumbers;
    }
}
