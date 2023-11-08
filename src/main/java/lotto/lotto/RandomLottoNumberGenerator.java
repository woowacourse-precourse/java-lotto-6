package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class RandomLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
