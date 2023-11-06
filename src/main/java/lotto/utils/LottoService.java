package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

import static lotto.global.constant.LottoConstant.*;

public class LottoService {

    public Lotto generateUserLotto(){
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END, LOTTO_NUMBER_COUNT);
        return new Lotto(randomNumbers);
    }
}
