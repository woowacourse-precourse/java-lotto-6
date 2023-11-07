package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.view.Constants.*;

public class LottoNumbers {


    public List<Integer> setLottoNumbers() {
        List<Integer> LottoNums = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, NUM_OF_LOTTO);
        Collections.sort(LottoNums);
        return LottoNums;
    }

}
