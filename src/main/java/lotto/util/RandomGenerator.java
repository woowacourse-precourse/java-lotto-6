package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.model.LottoInfo.END_NUMBER;
import static lotto.model.LottoInfo.START_NUMBER;

public final class RandomGenerator {

    public static List<Integer> getAutoNumbers(int count){
        return Randoms.pickUniqueNumbersInRange(START_NUMBER,END_NUMBER,count);
    }
}
