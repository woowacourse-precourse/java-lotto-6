package common;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Random;

public class LottoNumberGenerator {
    public static List<Integer> generateLottoNumber(){
        return Randoms
                .pickUniqueNumbersInRange(Constant.LOTTO_MIN, Constant.LOTTO_MAX, Constant.LOTTO_SIZE);
    }
}
