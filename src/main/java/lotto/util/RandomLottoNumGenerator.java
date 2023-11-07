package lotto.util;

import static lotto.domain.LottoConstraint.LOTTO_LENGTH;
import static lotto.domain.LottoConstraint.MAX_LOTTO_NUM;
import static lotto.domain.LottoConstraint.MIN_LOTTO_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumGenerator {

    public static List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_LENGTH);
    }

}
