package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final int amount;

    private LottoGenerator(int amount) {
        this.amount = amount;
    }

    public static LottoGenerator from(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException();
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return new LottoGenerator(amount);
    }

    public List<Lotto> generate() {
        return IntStream.range(0, amount / 1000)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .collect(Collectors.toList());
    }
}