package lotto.domain;

import lotto.constant.LottoRank;
import lotto.util.NumberGenerator.INumberGenerator;
import lotto.util.NumberGenerator.NumberGenerator;

import java.util.Arrays;
import java.util.EnumMap;
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

    public LottoStatistics calculate(Result result) {

        EnumMap<LottoRank, Integer> map = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> map.put(lottoRank, 0));

        lottoPack.stream()
                .map(lotto -> lotto.calculate(result))
                .forEach(rank -> map.put(rank, map.get(rank) + 1));

        return new LottoStatistics(map);

    }

    @Override
    public String toString() {

        List<String> lottoStrings = lottoPack.stream()
                .map(Lotto::toString)
                .toList();

        return String.join("\n", lottoStrings);

    }

}
