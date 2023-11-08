package lotto.domain;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;

public class LottoGenerator {
        public LottoGenerator() {
        }
        public static List<Integer> startRandom(){
                List<Integer> randomNumbers= Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER
                        , Constants.LOTTO_MAX_NUMBER
                        , Constants.LOTTO_MAX_SIZE);
                Collections.sort(randomNumbers);
                return randomNumbers;
        }
}
