package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class LottoMachine {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_LENGTH = 6;
    public static Lotto createLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE,MAX_RANGE,LOTTO_LENGTH);
        return new Lotto(lottoNumbers);
    }
}
