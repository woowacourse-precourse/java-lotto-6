package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int COUNT_NUMBER = 6;
    public static List<Integer> createLottoNumber(){
       return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_NUMBER);
    }
}
