package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.wrapper.PurchaseAmout;
import lotto.utils.LottoConstant;

public class LottoVendingMachine {
    private static final int START_COUNT = 0;
    public Lottos buyLottos(PurchaseAmout purchaseAmout) {
        int lottoCount = purchaseAmout.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int count = START_COUNT; count < lottoCount; count++) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    private Lotto createLotto() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() != LottoConstant.LOTTO_NUMBERS_LENGTH.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(
                    LottoConstant.MIN_LOTTO_NUMBER.getNumber(), LottoConstant.MAX_LOTTO_NUMBER.getNumber());
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return new Lotto(randomNumbers);
    }
}
