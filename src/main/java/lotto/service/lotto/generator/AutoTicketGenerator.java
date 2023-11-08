package lotto.service.lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.stream.Collectors;

import static lotto.constant.LottoConfig.*;

public class AutoTicketGenerator extends TicketGenerator {
    public AutoTicketGenerator(){
        super(LOTTO_START_NUMBER.getValue(), LOTTO_END_NUMBER.getValue(), LOTTO_COUNT_NUMBER.getValue());
    }
    @Override
    public Lotto createLotto() {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count)
                .stream()
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }
}
