package lotto.service.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.LottoBall;

public class RandomNumbersGenerator implements NumbersGenerator {
    @Override
    public List<Integer> generateUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(LottoBall.MIN_RANGE, LottoBall.MAX_RANGE, count);
    }
}
