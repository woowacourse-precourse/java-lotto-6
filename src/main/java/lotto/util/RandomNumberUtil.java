package lotto.util;

import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Lotto;

public class RandomNumberUtil {
    public List<Integer> createSixUniqueRandomNumber() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange
                (Lotto.MINIMUM_LOTTO_NUMBER.getLottoNumber(),
                Lotto.MAXIMUM_LOTTO_NUMBER.getLottoNumber(),
                Lotto.NUMBER_OF_REQUIRED_LOTTO_NUMBER.getLottoNumber());
        return makeAscendingList(lotto);
    }

    public List<Integer> makeAscendingList(List<Integer> lotto) {
        Collections.sort(lotto);
        return lotto;
    }
}
