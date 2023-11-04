package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.IntStream;

public class LottoPublisher {

    private static final int MIN_RANGE_VALUE = 1;
    private static final int MAX_RANGE_VALUE = 45;
    private static final int NUMBER_OF_PICK = 6;


    public LottoPublisher() {
    }

    public List<Lotto> publishLotto(final Long purchaseAmount) {
        int purchasedLottoCount = calculateLottoAmount(purchaseAmount);
        return IntStream.range(0, purchasedLottoCount)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private int calculateLottoAmount(final Long purchaseAmount) {
        return (int) (purchaseAmount / 1000);
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE_VALUE, MAX_RANGE_VALUE, NUMBER_OF_PICK)
                .stream()
                .sorted(Integer::compareTo)
                .toList();

        return new Lotto(randomNumbers);
    }
}
