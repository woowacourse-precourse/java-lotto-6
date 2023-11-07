package lotto.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class NumberGenerator {
    private List<Integer> lottoNumbers = new ArrayList<>();

    public List<Integer> getNumber() {
        lottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
