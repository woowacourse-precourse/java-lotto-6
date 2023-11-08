package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.IntConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoMachine implements LottoMachine {
    private static final int LOTTO_SIZE = IntConstants.LOTTO_SIZE.getValue();
    private static final int MIN_LOTTO_NUMBER = IntConstants.MIN_LOTTO_NUMBER.getValue();
    private static final int MAX_LOTTO_NUMBER = IntConstants.MAX_LOTTO_NUMBER.getValue();

    @Override
    public List<Integer> generate() {
        List<Integer> randomLotto = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
        List<Integer> copyRandomLotto = new ArrayList<>(randomLotto);
        Collections.sort(copyRandomLotto);
        return copyRandomLotto;
    }
}
