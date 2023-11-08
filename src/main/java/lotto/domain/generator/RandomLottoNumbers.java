package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import static lotto.congin.LottoConfing.*;


public class RandomLottoNumbers {

    public static List<Integer> getValue() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LoTTO_LENGTH);
    }

}
