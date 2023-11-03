package lotto.utill;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import static lotto.congin.LottoConfing.*;


public class RandomNumberProvider {

    public static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LoTTO_LENGTH);
    }

}
