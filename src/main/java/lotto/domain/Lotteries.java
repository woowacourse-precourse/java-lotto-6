package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(int purchaseCount, NumberGenerator numberGenerator) {
        this.lotteries = generateLotteries(purchaseCount, numberGenerator);
    }

    public static Lotteries of(int purchaseCount, NumberGenerator numberGenerator) {
        return new Lotteries(purchaseCount, numberGenerator);
    }

    private List<Lotto> generateLotteries(int purchaseCount, NumberGenerator numberGenerator) {
        List<Lotto> lottos = IntStream.range(0, purchaseCount)
                .mapToObj(i -> new Lotto(generateLottoNumbers(numberGenerator)))
                .collect(Collectors.toList());

        return Collections.unmodifiableList(lottos);
    }

    private List<Integer> generateLottoNumbers(NumberGenerator numberGenerator) {
        return numberGenerator.generateLottoNumbers().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getNumbersOfLotteries() {
        List<List<Integer>> lotteriesNumbers = new ArrayList<>();
        for (Lotto lotto : lotteries) {
            lotteriesNumbers.add(lotto.getNumbers());
        }
        return lotteriesNumbers;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
