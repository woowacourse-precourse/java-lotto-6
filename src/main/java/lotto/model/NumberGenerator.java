package lotto.model;


import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class NumberGenerator {

    public List<Integer> getNumber() {
        List<Integer> lottoNumbers;

        lottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
