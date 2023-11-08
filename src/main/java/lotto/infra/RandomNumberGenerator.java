package lotto.infra;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate(final int start, final int end, final int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
