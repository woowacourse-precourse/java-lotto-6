package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GenerateLottoNumber {
    private static final List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    public static List<Integer> generate() {
        return lottoNumber;
    }

}
