package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private static final int RANGE_NUMBER=6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static List<Integer> lotto;

    public static List<Integer> setRandomNumbers(){
        lotto = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, RANGE_NUMBER);
        List<Integer> lottoLine = new ArrayList<>(lotto);
        Collections.sort(lottoLine);
        return lottoLine;
    }
}
