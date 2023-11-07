package lotto.domain.generator.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberStrategy implements NumberGenerationStrategy {

    @Override
    public List<Integer> generateNumbers(int count, int min, int max) {
        return Randoms.pickUniqueNumbersInRange(min, max, count);
    }
}
