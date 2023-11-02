package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_LIMIT_VALUE = 6;


    private LottoFactory() {
    }

    public static Lotto getLotto(){
        return new Lotto(getSortedLottoNumbers());
    }

    private static List<Integer> getSortedLottoNumbers() {
        List<Integer> lottoNumbers = getLottoNumbers();
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> getLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_LIMIT_VALUE);
    }
}
