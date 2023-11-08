package lotto.model;

import static lotto.util.Constant.LOTTO_MIN_NUMBER;
import static lotto.util.Constant.LOTTO_MAX_NUMBER;
import static lotto.util.Constant.LOTTO_LENGTH;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMaker {
    public List<Integer> getLotto() {
        List<Integer> lotto = new ArrayList<>(Randoms
                .pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_LENGTH));
        lotto.sort(Comparator.naturalOrder());
        return lotto;
    }
}
