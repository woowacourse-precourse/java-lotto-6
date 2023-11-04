package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.generator.RandomStrategy;

public class LottoGame {
    public Lotto generateLotto(RandomStrategy randomGenerator) {
        List<Integer> lotto = new ArrayList<>();
        while (!hasStandardSize(lotto, Lotto.STANDARD_SIZE)) {
            addAlternativeNumber(lotto, randomGenerator.generate(
                    () -> Randoms.pickNumberInRange(Lotto.MIN_VALUE, Lotto.MAX_VALUE))
            );
        }
        Collections.sort(lotto);
        return Lotto.from(lotto);
    }

    private void addAlternativeNumber(List<Integer> lotto, int randomNumber) {
        if (hasDuplicatedNumber(lotto, randomNumber)) {
            return;
        }
        lotto.add(randomNumber);
    }

    private int generateRandomNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }

    private boolean hasStandardSize(List<Integer> lotto, int standardSize) {
        return lotto.size() == standardSize;
    }

    private boolean hasDuplicatedNumber(List<Integer> lotto, int generatedNumber) {
        if (lotto.contains(generatedNumber)) {
            return true;
        }
        return false;
    }
}
