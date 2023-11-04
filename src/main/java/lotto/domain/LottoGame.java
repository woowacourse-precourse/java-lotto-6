package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    public static final int STANDARD_SIZE = 6;

    public Lotto generateLotto() {
        List<Integer> lotto = new ArrayList<>();
        while (!hasStandardSize(lotto, STANDARD_SIZE)) {
            addAlternativeNumber(lotto, generateRandomNumberInRange(1, 45));
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

    private boolean hasStandardSize(List<Integer> lotto, int standardSize) {
        return lotto.size() == standardSize;
    }

    private int generateRandomNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }

    private boolean hasDuplicatedNumber(List<Integer> lotto, int generatedNumber) {
        if (lotto.contains(generatedNumber)) {
            return true;
        }
        return false;
    }
}
