package lotto.factory;

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
        return new Lotto(randomList);
    }
}
