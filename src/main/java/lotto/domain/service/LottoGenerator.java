package lotto.domain.service;

import java.util.List;
import lotto.domain.model.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
public class LottoGenerator {
    public Lotto generateLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
