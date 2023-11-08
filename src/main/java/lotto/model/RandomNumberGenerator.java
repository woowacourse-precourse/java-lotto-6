package lotto.model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generateUniqueNumbers(int min, int max, int size) {
        return Randoms.pickUniqueNumbersInRange(min, max, size);
    }
}
