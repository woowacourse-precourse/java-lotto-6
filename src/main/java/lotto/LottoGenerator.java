package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    public Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
}
