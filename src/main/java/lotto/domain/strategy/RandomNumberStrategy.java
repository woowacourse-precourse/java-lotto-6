package lotto.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberStrategy implements LottoNumberStrategy {

    @Override
    public List<Integer> createNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
