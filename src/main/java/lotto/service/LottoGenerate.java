package lotto.service;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class LottoGenerate {
    public static Lotto generate(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
