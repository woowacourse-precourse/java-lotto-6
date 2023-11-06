package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.EnumList.ConstantLotto;

public class RandomLotto {

    public List<Integer> randomLotto() {
        return Randoms.pickUniqueNumbersInRange(ConstantLotto.MIN_NUMBER.value(),ConstantLotto.MAX_NUMBER.value(), ConstantLotto.LOTTO_SIZE.value());
    }
}
