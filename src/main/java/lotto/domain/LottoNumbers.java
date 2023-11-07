package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.view.Constants.*;

public class LottoNumbers {
    private static List<Integer> lottoNumberList;

    public List<Integer> setLottoNumbers() {
        lottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, NUM_OF_LOTTO);
        List<Integer> lottoNums = new ArrayList<>(lottoNumberList);
        Collections.sort(lottoNums);
        return lottoNums;
    }

}
