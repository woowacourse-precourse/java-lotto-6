package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.service.NumberGenerateStrategy;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
