package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.generator.RandomStrategy;

public class LottoGenerator {
    public static Lotto generateLotto(RandomStrategy randomGenerator) {
        List<Integer> lotto = new ArrayList<>();
        while (!hasStandardSize(lotto, Lotto.STANDARD_SIZE)) {
            addAlternativeNumber(lotto, randomGenerator.generate());
        }
        Collections.sort(lotto);
        return Lotto.from(lotto);
    }

    private static void addAlternativeNumber(List<Integer> lotto, int randomNumber) {
        if (hasDuplicatedNumber(lotto, randomNumber)) {
            return;
        }
        lotto.add(randomNumber);
    }

    private static boolean hasStandardSize(List<Integer> lotto, int standardSize) {
        return lotto.size() == standardSize;
    }

    private static boolean hasDuplicatedNumber(List<Integer> lotto, int generatedNumber) {
        if (lotto.contains(generatedNumber)) {
            return true;
        }
        return false;
    }
}
