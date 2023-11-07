package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Constant.*;
public class LottoNumberGenerator {
    private static List<Integer> lottoNumbers;

    public LottoNumberGenerator() {
    }

    public static List<Integer> setLottoNumber() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_LOTTO_NUMBER);
        List<Integer> lottoNumberList = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

}
