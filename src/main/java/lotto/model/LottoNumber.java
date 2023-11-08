package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.NumberConstants.*;
public class LottoNumber {
    private static List<Integer> lottoNumbers;

    public LottoNumber() {
    }

    public static List<Integer> setLottoNumber() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE);
        List<Integer> lottoNumberList = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

}
