package lotto.core;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.constValue.ConstNumber.*;

public class Random {
    public static List<Integer> getRandomNumbers(){
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(MIX_LOTTO_NUMBER,MAX_LOTTO_NUMBER,LOTTO_NUMBER_LENGTH);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}
