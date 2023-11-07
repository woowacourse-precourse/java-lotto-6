package lotto.domain.lottomachine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Number;

public class RandomLottoMachine implements LottoMachine{

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Number.MIN_NUMBER, Number.MAX_NUMBER, Lotto.LOTTO_LENGTH);
    }
}
