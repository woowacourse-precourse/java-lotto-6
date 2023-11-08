package lotto.model;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoNumberGenerator {

    public List<Integer> generate() {
        List<Integer> lottoNumbers = pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers.stream().sorted().collect(Collectors.toList());

        return lottoNumbers;
    }
}
