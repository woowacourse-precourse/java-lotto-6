package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.RandomGenerator;

public class LottoGame {
    public static final int STANDARD_SIZE = 6;
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;

    public Lotto generateLotto(RandomGenerator randomGenerator) {
        List<Integer> lotto = new ArrayList<>();
        while (!hasStandardSize(lotto, STANDARD_SIZE)) {
            addAlternativeNumber(lotto, randomGenerator.generate(
                    () -> Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE))
            );
        }
        Collections.sort(lotto);
        return new Lotto(lotto);
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
