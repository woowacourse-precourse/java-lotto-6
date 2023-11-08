package lotto.lottoNumberGenerator.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> makeLottoNumbers() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }

}
