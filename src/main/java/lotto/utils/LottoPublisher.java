package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoPublisher {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int NUM_OF_LOTTO_NUMBER = 6;

    public Lottos createLottos(final PurchaseAmount purchaseAmount) {
        return Stream.generate(this::generateRandomNumbers)
                .limit(purchaseAmount.numOfLotto())
                .map(Lotto::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUM_OF_LOTTO_NUMBER);
    }
}
