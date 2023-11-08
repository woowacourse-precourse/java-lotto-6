package lotto.domain.vendingMachine.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;

import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {

    public Lotto generate() {
        List<Integer> autoNumber = Randoms.pickUniqueNumbersInRange(
                LottoConstants.MIN_NUMBER_OF_LOTTO.getValue(),
                LottoConstants.MAX_NUMBER_OF_LOTTO.getValue(),
                LottoConstants.LOTTO_NUMBER_COUNT.getValue());

        return Lotto.of(autoNumber);
    }


}
