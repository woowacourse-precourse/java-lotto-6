package lotto.util.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    public static Lotto generateLotto(RandomStrategy randomGenerator) {
        List<Integer> sortingNumbers = new ArrayList<>(randomGenerator.generate());
        Collections.sort(sortingNumbers);
        return Lotto.from(sortingNumbers);
    }
}
