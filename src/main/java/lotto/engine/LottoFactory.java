package lotto.engine;

import static lotto.engine.LottoSystemConstant.LOTTO_NUMBER_LENGTH;
import static lotto.engine.LottoSystemConstant.NUMBER_MAXIMUM_VALUE;
import static lotto.engine.LottoSystemConstant.NUMBER_MINIMUM_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Lotto;

public class LottoFactory {
    public LottoFactory() {
    }

    public List<Lotto> issueLotto(int quantity) {
        return Stream.generate(() -> Randoms.pickUniqueNumbersInRange(
                        NUMBER_MINIMUM_VALUE.value(),
                        NUMBER_MAXIMUM_VALUE.value(),
                        LOTTO_NUMBER_LENGTH.value())
                )
                .limit(quantity)
                .peek(Collections::sort)
                .map(Lotto::new)
                .toList();
    }

    public String showTotalLotto(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::showNumbers)
                .collect(Collectors.joining("\n"));
    }
}
