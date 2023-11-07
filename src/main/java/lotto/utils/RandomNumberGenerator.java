package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;
import lotto.config.LottoGameRule;

public class RandomNumberGenerator implements NumberGenerator {

    private final int min;
    private final int max;

    public RandomNumberGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Lotto generate() {
        return new Lotto(pickRandomNumber());
    }

    private List<Integer> pickRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(min, max, LottoGameRule.LOTTO_SIZE.value());
    }
}
