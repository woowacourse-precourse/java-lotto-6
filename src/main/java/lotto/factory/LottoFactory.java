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
        List<Integer> randomList = randomNumbersGenerator.get();
        List<Integer> sortedRandomList = sortRandomNumber(randomList);
        return new Lotto(sortedRandomList);
    }

    private List<Integer> sortRandomNumber(List<Integer> randomList) {
        List<Integer> sortedRandomList = new ArrayList<>(randomList);
        sortedRandomList.sort(null);
        return sortedRandomList;
    }
}
