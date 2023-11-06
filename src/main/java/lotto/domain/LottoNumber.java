package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int COUNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static List<Integer> lottoNumbers;

    public List<Integer> setLottoNumber() {
        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_LOTTO_NUMBER);
        lottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
