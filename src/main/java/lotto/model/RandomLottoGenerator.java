package lotto.model;

import static lotto.model.LottoAttribute.LOTTO_TICKET_SIZE;
import static lotto.model.LottoAttribute.MAX_LOTTO_NUMBER;
import static lotto.model.LottoAttribute.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        return new Lotto(pickRandomNumbers());
    }

    private List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                LOTTO_TICKET_SIZE
        );
    }
}
