package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    public List<List<Integer>> getRandomNumbers(int count) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_MIN_NUMBER,
                    LottoConstants.LOTTO_MAX_NUMBER, LottoConstants.LOTTO_SIZE));
        }
        return result;
    }
}
