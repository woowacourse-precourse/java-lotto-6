package lotto.domain;

import lotto.constant.LottoRank;
import util.NumberGenerator.INumberGenerator;
import util.NumberGenerator.NumberGenerator;

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

    public Result calculate(WinningNumbers winningNumbers, WinningNumber bonusNumber) {

        EnumMap<LottoRank, Integer> map = new EnumMap<>(LottoRank.class);

        lottoPack.stream()
                .map(lotto -> lotto.calculate(winningNumbers, bonusNumber))
                .forEach(rank -> map.put(rank, map.get(rank) + 1));

        return new Result(map);

    }

    @Override
    public String toString() {

        List<String> lottoStrings = lottoPack.stream()
                .map(Lotto::toString)
                .toList();

        return String.join("\n", lottoStrings);

    }

}
