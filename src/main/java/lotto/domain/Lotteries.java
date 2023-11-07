package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.util.RandomNumberGenerator;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(int purchaseCount) {
        this.lotteries = generateLotteries(purchaseCount);
    }

    public static Lotteries from(int purchaseCount) {
        return new Lotteries(purchaseCount);
    }

    private List<Lotto> generateLotteries(int purchaseCount) {
        return IntStream.range(0, purchaseCount)
                .mapToObj(i -> this.generateLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        return new Lotto(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        return RandomNumberGenerator.generateLottoNumbers().stream()
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
