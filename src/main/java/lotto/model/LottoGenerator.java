package lotto.model;

import static lotto.controller.GameConstants.LOTTO_NUMBER_SIZE;
import static lotto.controller.GameConstants.MAX_NUMBER;
import static lotto.controller.GameConstants.MIN_NUMBER;

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
