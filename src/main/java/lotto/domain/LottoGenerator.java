package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.LottoConstants;

public class LottoGenerator {
    public List<Integer> generateLotto() {
        List<Integer> sortedList = new ArrayList<Integer>(
                Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER,
                        LottoConstants.MAX_LOTTO_NUMBER,
                        LottoConstants.LOTTO_NUMBER_COUNT));

        Collections.sort(sortedList);
        return sortedList;
    }
}
