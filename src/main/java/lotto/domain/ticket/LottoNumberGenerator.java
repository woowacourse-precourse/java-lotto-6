package lotto.domain.ticket;

import static lotto.domain.ticket.LottoNumberConfig.MINIMUM_RANGE;
import static lotto.domain.ticket.LottoNumberConfig.MAXIMUM_RANGE;
import static lotto.domain.ticket.LottoNumberConfig.NUMBER_COUNT;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_RANGE.getValue(),
                MAXIMUM_RANGE.getValue(), NUMBER_COUNT.getValue()).stream()
                .sorted()
                .toList();
    }
}
