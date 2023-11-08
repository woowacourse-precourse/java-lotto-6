package lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private final RandomGenerator randomGenerator;

    public LottoMachine(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Lotto issueAutomatically() {
        return new Lotto(randomGenerator.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.SIZE));
    }

    public List<Lotto> issueAutomatically(LottoPurchaseAmount lottoPurchaseAmount) {
        return IntStream.range(0, lottoPurchaseAmount.getTicketsCount())
                .mapToObj(i -> issueAutomatically())
                .toList();
    }
}
