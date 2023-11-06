package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static Lotto createLotto() {
        return createLotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static Lotto createLotto(List<Integer> lottoNumber) {
        return new Lotto(new ArrayList<>(lottoNumber));
    }
}
