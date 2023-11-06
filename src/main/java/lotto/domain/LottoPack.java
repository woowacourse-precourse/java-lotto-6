package lotto.domain;

import lotto.constant.LottoRank;
import lotto.util.NumberGenerator.INumberGenerator;
import lotto.util.NumberGenerator.NumberGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class LottoPack {

    private final List<Lotto> lottoPack;

    public LottoPack(int count, INumberGenerator numberGenerator) {
        lottoPack = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(numberGenerator.generateNumbers()))
                .toList();
    }

    public static LottoPack createLottoPack(int count) {
        return new LottoPack(count, new NumberGenerator());
    }

    public int size() {
        return lottoPack.size();
    }

    public List<LottoRank> calculate(Result result) {
        return lottoPack.stream().map(lotto -> lotto.calculate(result)).toList();
    }

    @Override
    public String toString() {

        List<String> lottoStrings = lottoPack.stream()
                .map(Lotto::toString)
                .toList();

        return String.join("\n", lottoStrings);

    }

}
