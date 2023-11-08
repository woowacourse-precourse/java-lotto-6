package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import lotto.util.RandomLotteryGenerator;
import lotto.util.RandomNumberGenerator;

public class LotteryPapers {
    private final List<Lotto> lotteries;
    private final long lotteryAmount;

    private LotteryPapers(List<Lotto> lotteries, long lotteryAmount) {
        this.lotteryAmount = lotteryAmount;
        this.lotteries = lotteries;
    }

    public static LotteryPapers createLotteryFrom(long lotteryAmount) {
        RandomNumberGenerator randomLotteryGenerator = new RandomLotteryGenerator();

        List<Lotto> lotteries = LongStream.range(0, lotteryAmount)
                .mapToObj(i -> new Lotto(randomLotteryGenerator.generateRandomLotteries()))
                .toList();

        return new LotteryPapers(lotteries, lotteryAmount);
    }

    public List<List<Integer>> getLottoNumber() {

        return lotteries.stream()
                .map(Lotto::getLottoNumbers)
                .collect(Collectors.toList());
    }
}
