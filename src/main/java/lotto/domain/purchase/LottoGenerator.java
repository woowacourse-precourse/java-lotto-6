package lotto.domain.purchase;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.number.Lotto;
import lotto.domain.number.Lottos;
import lotto.domain.number.Number;

public class LottoGenerator {
    private static final int NUMBER_MINIMUM = 1;
    private static final int NUMBER_MAXIMUM = 45;
    private static final int LOTTO_SIZE = 6;

    public Lottos generateAutomaticallyBy(PurchaseAmount purchaseAmount) {
        int purchaseQuantity = purchaseAmount.calculatePurchaseQuantity();
        List<Lotto> lottos = Stream.generate(this::generateAutomatically)
                .limit(purchaseQuantity)
                .toList();
        return new Lottos(lottos);
    }

    private Lotto generateAutomatically() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(NUMBER_MINIMUM, NUMBER_MAXIMUM, LOTTO_SIZE);
        Set<Number> numberSet = integers.stream()
                .map(Number::new)
                .collect(Collectors.toSet());
        return new Lotto(numberSet);
    }
}
