package strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;

public class QuickpickIssuanceStrategy implements IssuanceStrategy {

    @Override
    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return Lotto.from(numbers);
    }
}
