package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.wrapper.PurchaseAmout;
import lotto.utils.LottoConstantValue;

public class VendingMachine {
    private static final int START_COUNT = 0;
    private final PurchaseAmout purchaseAmout;

    public VendingMachine(PurchaseAmout purchaseAmount) {
        this.purchaseAmout = purchaseAmount;
    }
    public Lottos getLottos() {
        int lottoCount = purchaseAmout.getAvailableLottoCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int count = START_COUNT; count < lottoCount; count++) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    private Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstantValue.MIN_LOTTO_NUMBER.get(),
                    LottoConstantValue.MAX_LOTTO_NUMBER.get(),
                    LottoConstantValue.LOTTO_NUMBERS_LENGTH.get());
        return new Lotto(randomNumbers);
    }
}
