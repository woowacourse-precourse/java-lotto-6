package lotto.service;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoNumber {

    private static final int MIN=1;
    private static final int MAX=1;
    private static final int COUNT=1;
    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);
    }
}
