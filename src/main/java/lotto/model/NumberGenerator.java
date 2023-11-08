package lotto.model;

import static lotto.constant.Constants.LOTTO_NUMBER_COUNT;
import static lotto.constant.Constants.MAX_LOTTO_NUMBER;
import static lotto.constant.Constants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    public static List<Integer> getLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
