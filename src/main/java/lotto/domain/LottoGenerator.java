package lotto.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import static constant.MessageList.*;

public class LottoGenerator {
    public LottoGenerator() {
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_RANGE_OF_NUMBER, MAXIMUM_RANGE_OF_NUMBER, TOTAL_LOTTO_SIZE);
    }
}
