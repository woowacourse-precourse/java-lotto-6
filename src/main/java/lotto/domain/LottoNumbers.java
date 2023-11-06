package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int NUM_OF_LOTTO =6;
    private static final int MIN_NUM =1;
    private static final int MAX_NUM =45;

    public List<Integer> setLottoNumbers(){
        List<Integer> LottoNums = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, NUM_OF_LOTTO);
        Collections.sort(LottoNums);
        return LottoNums;
    }

}
