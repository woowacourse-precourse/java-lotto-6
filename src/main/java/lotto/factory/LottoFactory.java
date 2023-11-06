package lotto.factory;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.RandomNumbersGenerator;

public class LottoFactory {

    private final RandomNumbersGenerator randomNumbersGenerator;

    public LottoFactory(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public Lotto createLotto() {
        List<Integer> randomList = randomNumbersGenerator.createUniqueElementList();
        List<Integer> sortedRandomList = sortRandomNumber(randomList);
        return new Lotto(sortedRandomList);
    }

    private List<Integer> sortRandomNumber(List<Integer> randomList) {
        List<Integer> sortedRandomList = new ArrayList<>(randomList);
        sortedRandomList.sort(null);
        return sortedRandomList;
    }
}
