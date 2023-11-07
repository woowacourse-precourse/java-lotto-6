package lotto.domain;

import static lotto.domain.enums.LottoNumberRules.EXACT_LOTTO_COUNTS;
import static lotto.domain.enums.LottoNumberRules.MAX_LOTTO_NUMBER;
import static lotto.domain.enums.LottoNumberRules.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lottos generate(int availablePurchase) {
        return IntStream.range(0, availablePurchase)
                .mapToObj(value -> new Lotto(
                                Randoms.pickUniqueNumbersInRange(
                                        MIN_LOTTO_NUMBER.getValue(),
                                        MAX_LOTTO_NUMBER.getValue(),
                                        EXACT_LOTTO_COUNTS.getValue())
                        )
                )
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }
}
