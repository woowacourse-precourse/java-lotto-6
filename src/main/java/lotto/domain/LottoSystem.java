package lotto.domain;

import static lotto.utils.Randoms.pickUniqueNumbersInRange;

import java.util.List;
import java.util.stream.IntStream;

public class LottoSystem {

    private final List<Lotto> lotteries;

    private LottoSystem(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static LottoSystem of(int count) {
        List<Lotto> result = createLotteries(count);
        return new LottoSystem(result);
    }

    private static List<Lotto> createLotteries(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> new Lotto(pickUniqueNumbersInRange()))
                .toList();
    }

    public List<String> receiveLotteriesInfo() {
        return lotteries.stream()
                .map(Lotto::toString)
                .toList();
    }
}
