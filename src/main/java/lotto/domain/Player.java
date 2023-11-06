package lotto.domain;

import java.util.List;
import java.util.stream.LongStream;

public class Player {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final NumberGenerator numberGenerator;

    public Player(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> generateLottos(Money money) {
        long count = money.value() / 1_000;
        return LongStream.range(0, count)
            .mapToObj(i -> new Lotto(pickSortedUniqueRandomNumbers())).toList();
    }

    private List<Integer> pickSortedUniqueRandomNumbers() {
        List<Integer> randomNumbers = numberGenerator.pickUniqueNumbersInRange(
            START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
        return randomNumbers.stream().sorted().toList();
    }
}
