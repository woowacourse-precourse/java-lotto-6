package lotto.util.random;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.config.GameConfig;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateSorted() {
        List<Integer> numbers = new ArrayList<>(generateNumbers());
        Collections.sort(numbers);
        return numbers;
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                GameConfig.LOTTO_MIN_NUMBER,
                GameConfig.LOTTO_MAX_NUMBER,
                GameConfig.LOTTO_SIZE
        );
    }
}
