package lotto.model.lottogenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator extends LottoGenerator {

    @Override
    public List<Integer> generateList() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_SIZE);
    }
}
