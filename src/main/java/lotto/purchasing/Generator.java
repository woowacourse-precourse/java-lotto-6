package lotto.purchasing;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private List<Integer> generate(int minNumber, int maxNumber, int size) {
        return new ArrayList<>(pickUniqueNumbersInRange(minNumber, maxNumber, size));
    }
}