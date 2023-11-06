package lotto.service;

import static lotto.domain.constant.LottoConstant.MAX_NUMBER;
import static lotto.domain.constant.LottoConstant.MIN_NUMBER;
import static lotto.domain.constant.LottoConstant.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;

public class LottosService {

    private final Lottos lottos;

    public LottosService() {
        this.lottos = new Lottos();
    }

    public Lottos createLottos(LottoPurchase lottoPurchase) {
        int purchaseCount = 0;
        while (lottoPurchase.isRunning(purchaseCount)) {
            Lotto lotto = Lotto.create(createRandomNumbers());
            lottos.save(lotto);
            purchaseCount++;
        }
        return lottos;
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getNumber(), MAX_NUMBER.getNumber(),
                NUMBER_COUNT.getNumber());
        Collections.sort(numbers);
        return numbers;
    }
}
