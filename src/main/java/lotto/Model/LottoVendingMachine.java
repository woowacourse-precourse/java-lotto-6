package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Controller.LottoController;

public class LottoVendingMachine {

    public Lotto createValidLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LottoMachine.LOTTO_NUMBER_MIN_RANGE,
                LottoMachine.LOTTO_NUMBER_MAX_RANGE,
                LottoController.LOTTO_NUMBER_AMOUNT);
        return new Lotto(randomNumbers);
    }

}
