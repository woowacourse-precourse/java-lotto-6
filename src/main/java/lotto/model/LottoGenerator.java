package lotto.model;

import static lotto.util.GameConstants.LOTTO_NUMBER_SIZE;
import static lotto.util.GameConstants.MAX_NUMBER;
import static lotto.util.GameConstants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static Lotto createLotto() {
        return createLotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(),
                LOTTO_NUMBER_SIZE.getNumber()));
    }

    public static Lotto createLotto(List<Integer> lottoNumber) {
        return new Lotto(new ArrayList<>(lottoNumber));
    }
}
