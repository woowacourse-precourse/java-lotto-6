package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final int STANDARD_SIZE = 6;

    public Lotto generateLotto() {
        List<Integer> lotto = new ArrayList<>();
        while (!hasStandardSize(lotto, STANDARD_SIZE)) {
            int randomNumber = generateRandomNumberInRange(1, 45);
            if (hasDuplicatedNumber(lotto, randomNumber)) {
                continue;
            }
            lotto.add(randomNumber);
        }
        return new Lotto(lotto);
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
