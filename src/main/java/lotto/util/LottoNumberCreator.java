package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoPrice;
import lotto.model.TotalLotto;

import java.util.List;

public class LottoNumberCreator {
    private final TotalLotto totalLotto;

    public LottoNumberCreator(LottoPrice lottoPrice) {
        int numberForGenerateLottos = lottoPrice.getPrice() / 1000;
        this.totalLotto = createLottoTickets(numberForGenerateLottos);
    }


    private TotalLotto createLottoTickets(int numberForGenerateLottos) {
        TotalLotto totalLotto = new TotalLotto();
        for (int i = 0; i < numberForGenerateLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            totalLotto.generateTotalLotto(lotto);
        }
        return totalLotto;
    }

    public TotalLotto getTotalLotto() {
        return totalLotto;
    }
}
