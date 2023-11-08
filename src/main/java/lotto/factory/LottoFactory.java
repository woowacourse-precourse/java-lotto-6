package lotto.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;

public class LottoFactory {

    private final Supplier<List<Integer>> randomNumbersGenerator;

    public LottoFactory(Supplier<List<Integer>> randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public Lotto createLotto() {
        List<Integer> randomNumbers = randomNumbersGenerator.get();
        List<Integer> sortedRandomNumbers = sortRandomNumber(randomNumbers);
        return new Lotto(sortedRandomNumbers);
    }

    private List<Integer> sortRandomNumber(List<Integer> randomNumbers) {
        List<Integer> sortedRandomNumbers = new ArrayList<>(randomNumbers);
        sortedRandomNumbers.sort(null);
        return sortedRandomNumbers;
    }
}
