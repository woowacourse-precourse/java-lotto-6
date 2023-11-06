package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.constant.LottoRule;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoPublisher {

    public Lottos createLottos(final PurchaseAmount purchaseAmount) {
        return Stream.generate(this::generateRandomNumbers)
                .limit(purchaseAmount.numOfLotto())
                .map(Lotto::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoRule.MIN_NUMBER.toValue(),
                LottoRule.MAX_NUMBER.toValue(),
                LottoRule.NUM_OF_NUMBER.toValue());
    }
}
